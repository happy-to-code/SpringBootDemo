package com.example.yida.demo.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader reader;
        String line;
        //两个页面参数
        //据我观察这个url不变
        String backUrl = "http%3A%2F%2Fredmine.tvbanywhere.net%2Fredmine%2F";
        String authenticityToken = null;

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //get请求访问这个url是页面
        //获取auth_token
        HttpGet getParam = new HttpGet("https://report.elementwin.com/");
        CloseableHttpResponse response1 = httpClient.execute(getParam);
        InputStream inputStream1 = response1.getEntity().getContent();
        inputStreamReader = new InputStreamReader(inputStream1);
        reader = new BufferedReader(inputStreamReader);
        while ((line = reader.readLine()) != null) {
            if (line.contains("name=\"authenticity_token\"")) {
                System.out.println(line);
                String sub1 = line.substring(line.indexOf("value=\"") + 7);
                authenticityToken = sub1.substring(0, sub1.indexOf("\""));
            }
        }
        reader.close();
        inputStreamReader.close();
        inputStream1.close();
        //post 请求是登录操作
        HttpPost dologin = new HttpPost("http://redmine.tvbanywhere.net/redmine/login");
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("authenticity_token", authenticityToken));
        list.add(new BasicNameValuePair("back_url", backUrl));
        list.add(new BasicNameValuePair("zhangyifei_ms", "Ew123456"));

        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list);
        dologin.setEntity(urlEncodedFormEntity);

        HttpGet get1 = new HttpGet("https://report.elementwin.com/");
        CloseableHttpResponse response3 = httpClient.execute(get1);
        System.err.println("get" + get1.getURI());
        InputStream inputStream3 = response3.getEntity().getContent();
        inputStreamReader = new InputStreamReader(inputStream3);
        reader = new BufferedReader(inputStreamReader);
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}