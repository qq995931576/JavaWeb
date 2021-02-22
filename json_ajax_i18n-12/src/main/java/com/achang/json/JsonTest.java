package com.achang.json;

import com.achang.bean.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.*;

/******
 @author 阿昌
 @create 2020-12-03 16:51
 *******
 */
public class JsonTest {


    //javabean与json的转换
    @Test
    public void test1() {
        Person person = new Person(1, "张飞");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson()---将java对象转换为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);// {"id":1,"name":"张飞"}

        //fromJson()---将json字符串转换为java对象
        //参数一：json字符串对象        参数二：要转成的 类.class
        Person fromJson = gson.fromJson(personJsonString, Person.class);
        System.out.println(fromJson);// Person{id=1, name='张飞'}

    }


    //List和json 的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "刘备"));
        personList.add(new Person(2, "张飞"));
        personList.add(new Person(3, "关羽"));

        Gson gson = new Gson();

        //把List转换成Json字符串
        String personJsonList = gson.toJson(personList);
        System.out.println(personJsonList);// [{"id":1,"name":"刘备"},{"id":2,"name":"张飞"},{"id":3,"name":"关羽"}]

        //Json字符串转换成List集合
        List list = gson.fromJson(personJsonList, new PersonListType().getType());
        System.out.println(list);// [Person{id=1, name='刘备'}, Person{id=2, name='张飞'}, Person{id=3, name='关羽'}]
        System.out.println(list.get(0));//Person{id=1, name='刘备'}

    }


    //map和json的互转
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new Hashtable<>();

        personMap.put(1, new Person(1, "韩信"));
        personMap.put(2, new Person(2, "萧何"));

        Gson gson = new Gson();

        //把map集合转换成为json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);// {"2":{"id":2,"name":"萧何"},"1":{"id":1,"name":"韩信"}}

        //把json字符串转换成map集合
//        Map<Integer,Person> personJsonMap = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        //使用匿名内部类的方式
        Map<Integer, Person> personJsonMap = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());

        System.out.println(personJsonMap);// {2=Person{id=2, name='萧何'}, 1=Person{id=1, name='韩信'}}
        System.out.println(personMap.get(1));// Person{id=1, name='韩信'}

    }


}
