package com.chinasoft.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsoupTest {
    public static void main(String[] args) throws IOException {
        List<Teacher> list = new ArrayList<Teacher>();
        String path = JsoupTest.class.getClassLoader().getResource("teacher.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        Elements names = document.getElementsByTag("name");
        Elements genders = document.getElementsByTag("gender");
        Elements salarys = document.getElementsByTag("salary");
        String name = names.get(0).text();
        String gender = genders.get(0).text();
        String salary = salarys.get(0).text();
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setGender(gender);
        teacher.setSalary(Double.parseDouble(salary));
        list.add(teacher);
        for (Teacher teacher1 : list) {
            System.out.println(teacher1);
        }
    }
}
