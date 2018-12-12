package com.qdm.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author qiudm
 * @date 2018/11/5 10:03
 * @desc
 */
public class XmlTests {

    @Test
    public void pathTest() throws Exception {
        String property = System.getProperty("user.dir");
        System.out.println("property = " + property);

        File directory = new File("");//设定为当前文件夹
        String absolutePath = directory.getAbsolutePath();
        String canonicalPath = directory.getCanonicalPath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("canonicalPath = " + canonicalPath);

        String path = Class.class.getClass().getResource("/").getPath();
        System.out.println("path = " + path);

    }

    @Test
    public void getFile() throws Exception {


        String path = "D:\\ideal_project\\javagather\\java-gather\\jdk-api\\src\\main\\resources\\files\\xmlTest.xml";

        File file = new File(path);//设定为当前文件夹
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println("s = " + s);
        }

    }

    @Test
    public void saxTest() throws Exception {

        String path = "D:\\ideal_project\\javagather\\java-gather\\jdk-api\\src\\main\\resources\\files\\xmlTest.xml";
        File file = new File(path);

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();

        for (Element element : elements) {
            System.out.print("name=" + element.getName() + ", text=" + element.getText() + "\n");
        }

    }





}
