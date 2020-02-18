package com.chinasoft.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * 使用工具类解析远程网页信息(爬虫)
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {

        URL url= new URL("https://baike.baidu.com/item/" +
                "2019%E6%96%B0%E5%9E%8B%E5%86%A0%E7%8A%B6%E7%97%85%E6%AF%92/" +
                "24267858?fr=aladdin");
        Document document = Jsoup.parse(url,3000);
        System.out.println(document);
    }
}
