package com.achang.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author 阿昌
 * @create 2020-11-01 17:30
 */
public class Dom4jTest {

    //创建ducument对象
    @Test
    public void test1() throws Exception {
        //创建一个saxReader输出流，读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        Document documentObj = saxReader.read("src/books.xml");
        System.out.println(documentObj);//org.dom4j.tree.DefaultDocument@123772c4 [Document: name src/books.xml] 有输出就是可以来使用Dom4j

    }

    //读取boos.xml文件生成类 book类
    @Test
    public void test2() throws Exception {
        //1. 读取books.xml文件
        SAXReader saxReader = new SAXReader();
        //在Junit测试中，相对路径是从模块名开始算
        Document documentObj = saxReader.read("src/books.xml");
        //2. 通过文档对象获取根元素
        Element rootElement = documentObj.getRootElement();
        System.out.println(rootElement);//org.dom4j.tree.DefaultElement@39ed3c8d [Element: <books attributes: []/>]
        //3. 通过根元素获取book标签对象
        //element()和elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4. 遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            // asXML() 将标签对象转换为标签字符串
            Element nameElement = book.element("name");

            // getText() 可以获取标签中的文本内容
            String nameText = nameElement.getText();

            //elementText() 直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            //attributeValue() 获取指定属性名的属性值
            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue, nameText, Double.parseDouble(priceText), authorText));

        }
    }


}
