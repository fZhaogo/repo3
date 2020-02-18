package com.chinasoft.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {

    public static void main(String[] args) throws IOException {

//        获取Dom对象
//            1.获取xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("user.xml").getPath();
//             2.生成Dom对象,将xml中的数据读取并放到内存中
        Document document = Jsoup.parse(new File(path), "utf-8");
//        获取对应的Element对象
        Elements elements = document.getElementsByTag("name");
//        获取对象
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);
    }
}
