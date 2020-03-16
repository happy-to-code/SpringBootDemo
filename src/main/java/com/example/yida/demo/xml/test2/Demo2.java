package com.example.yida.demo.xml.test2;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/3/16 14:01
 */
@Slf4j
public class Demo2 {
    public static void main(String[] args) throws IOException {
        String s = "<xml><ToUserName><![CDATA[wx697368e10b88271a]]></ToUserName><FromUserName><![CDATA[sys]]></FromUserName><CreateTime>1584327484</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[change_external_contact]]></Event><ChangeType><![CDATA[add_external_contact]]></ChangeType><UserID><![CDATA[zhangying]]></UserID><ExternalUserID><![CDATA[wmiqFYEQAAtkp2Y1Dz-eYfIUpKAPuEKg]]></ExternalUserID><State><![CDATA[PRESALE]]></State><WelcomeCode><![CDATA[DDDOiYgAtqbaFaEkCoSrG9JdpZVG3L4zAxJZ1cJTT3g]]></WelcomeCode></xml>";

        decryptMsg(s);
    }

    public static void decryptMsg(String sMsg) throws IOException {
        InputStream targetStream = IOUtils.toInputStream(sMsg, StandardCharsets.UTF_8.name());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.info("创建DocumentBuilder失败{}", e);
        }
        Document doc = null;
        try {
            doc = builder.parse(targetStream);
        } catch (SAXException e) {
            log.info("解析报错SAXException{}", e);
        } catch (Throwable e) {
            log.info("解析报错Throwable{}", e);
        }
        log.info("Document doc{}", doc);

        // 从doc中获取值
        String toUserName = doc.getElementsByTagName("ToUserName").item(0).getFirstChild().getNodeValue();
        String fromUserName = doc.getElementsByTagName("FromUserName").item(0).getFirstChild().getNodeValue();
        String createTime = doc.getElementsByTagName("CreateTime").item(0).getFirstChild().getNodeValue();
        String msgType = doc.getElementsByTagName("MsgType").item(0).getFirstChild().getNodeValue();
        String event = doc.getElementsByTagName("Event").item(0).getFirstChild().getNodeValue();
        String changeType = doc.getElementsByTagName("ChangeType").item(0).getFirstChild().getNodeValue();
        String userID = doc.getElementsByTagName("UserID").item(0).getFirstChild().getNodeValue();
        String externalUserId = doc.getElementsByTagName("ExternalUserID").item(0).getFirstChild().getNodeValue();
        String state = null;
        if (null != doc.getElementsByTagName("State").item(0)) {
            state = doc.getElementsByTagName("State").item(0).getFirstChild().getNodeValue();
        }
        String welcomeCode = null;
        if (null != doc.getElementsByTagName("WelcomeCode").item(0)) {
            welcomeCode = doc.getElementsByTagName("WelcomeCode").item(0).getFirstChild().getNodeValue();
        }


    }


}
