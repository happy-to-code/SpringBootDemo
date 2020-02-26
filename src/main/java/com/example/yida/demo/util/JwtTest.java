package com.example.yida.demo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/12/18
 */
public class JwtTest {
    private static Clock clock = DefaultClock.INSTANCE;

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>(4);
        claims.put("ip", "127.0.0.8");
        claims.put("age", 18);

        String token = doGenerateToken(claims, "testjwt");
        System.out.println(token);
        System.out.println("-----------------------");

        String s1 = parseToken(token);
        System.out.println(s1);


    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    private static String parseToken(String token) {
        String subject = null;
        try {
            subject = getAllClaimsFromToken(token).getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

    private static Claims getAllClaimsFromToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey("my1Secret").parseClaimsJws(token);
        return claims.getBody();
    }

    /**
     * 生成token
     *
     * @param claims
     * @param subject
     * @return
     */
    private static String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .signWith(SignatureAlgorithm.HS512, "mySecret1")
                .setExpiration(expirationDate)
                .compact();
    }

    private static Date calculateExpirationDate(Date createdDate) {
        return DateUtils1.addDateSeconds(createdDate, 30000);
    }
}
