package com.example.yida.demo.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/12/12
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            //构建一个Client
            HttpClient client = new DefaultHttpClient();
            //构建一个POST请求
            HttpPost post = new HttpPost("https://report.elementwin.com/");
            //构建表单参数
            List<NameValuePair> formParams = new ArrayList<>();
            formParams.add(new BasicNameValuePair("zhangyifei_ms", "Ew12345611"));
            formParams.add(new BasicNameValuePair("zhangyifei126@yeah.net", "a717217"));

            //将表单参数转化为“实体”
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            //将“实体“设置到POST请求里
            post.setEntity(entity);

            //提交POST请求
            HttpResponse response = client.execute(post);
            //拿到返回的HttpResponse的"实体"
            HttpEntity result = response.getEntity();
            String content = EntityUtils.toString(result);
            //用httpcore.jar提供的工具类将"实体"转化为字符串打印到控制台
            System.out.println(content);
            if (content.contains("登陆成功")) {
                System.out.println("登陆成功！！！");
            }
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
