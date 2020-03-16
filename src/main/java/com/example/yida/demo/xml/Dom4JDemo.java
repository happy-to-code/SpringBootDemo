package com.example.yida.demo.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: cxx
 * Dom4j解析xml
 * @Date: 2018/5/30 12:21
 */
public class Dom4JDemo {
    public static void main(String[] args) throws Exception {
        String s = "<xml><ToUserName><![CDATA[wx697368e10b88271a]]></ToUserName><FromUserName><![CDATA[sys]]></FromUserName><CreateTime>1584327484</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[change_external_contact]]></Event><ChangeType><![CDATA[add_external_contact]]></ChangeType><UserID><![CDATA[zhangying]]></UserID><ExternalUserID><![CDATA[wmiqFYEQAAtkp2Y1Dz-eYfIUpKAPuEKg]]></ExternalUserID><State><![CDATA[PRESALE]]></State><WelcomeCode><![CDATA[DDDOiYgAtqbaFaEkCoSrG9JdpZVG3L4zAxJZ1cJTT3g]]></WelcomeCode></xml>";

        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        // Document document = reader.read(new File("src/main/resources/demo.xml"));
        Document document = reader.read(new File(s));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()) {
                Element stuChild = (Element) iterator1.next();
                System.out.println("节点名：" + stuChild.getName() + "---节点值：" + stuChild.getStringValue());
            }
        }
    }
}
