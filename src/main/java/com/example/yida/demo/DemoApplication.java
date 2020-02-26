package com.example.yida.demo;

import com.example.yida.demo.netty.demo1.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author zhangyifei
 */
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        try {
            new NettyServer(8089).start();
            System.out.println("http://127.0.0.1:6688/netty-websocket/index");
        } catch (Exception e) {
            System.out.println("NettyServerError:" + e.getMessage());
        }
    }
}

