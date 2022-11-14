package com.powernode.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ParseXMLByDom4jTest {
    @Test
    public void testParseMybatisConfigXML() throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //获取输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        Document document = reader.read(is);
        //获取文档的根标签
//        Element rootElement = document.getRootElement();
//        String rootElementName = rootElement.getName();
        String xpath = "/configuration/environments";
        Element element = (Element) document.selectSingleNode(xpath);
        System.out.println(element.attributeValue("default"));
        System.out.println(element);
        xpath = "/configuration/environments/environment[@id='" + element.attributeValue("default") + "']";
        Element element1 = (Element) element.selectSingleNode(xpath);
        Element transactionManager = element1.element("transactionManager");
        String type = transactionManager.attributeValue("type");
        System.out.println(type);
        System.out.println(element1.element("dataSource").attributeValue("type"));
        List<Element> property = element1.element("dataSource").elements();
        for (Element element2 : property) {
            System.out.println(element2.attribute("name") + element2.attributeValue("value"));
        }
        //获取mapper标签
        xpath = "//mapper";
        List<Node> nodes = document.selectNodes(xpath);
        for (Node node : nodes) {
            System.out.println(node.valueOf("@resource"));
        }
    }
}
