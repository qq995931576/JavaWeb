package com.achang.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/******
 @author 阿昌
 @create 2020-11-27 11:54
 *******
 */
public class Person {
    //需求: 输出Person类中普通属性，数组属性。list集合属性和map集合属性
    private int id;
    private String name;
    private String[] phone;
    private List<String> cities;
    private Map<String, Object> map;


    public Person() {
    }

    public Person(int id, String name, String[] phone, List<String> cities, Map<String, Object> map) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cities = cities;
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + Arrays.toString(phone) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
