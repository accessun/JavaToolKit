package io.github.accessun.bean;

import java.util.Map;

public class Person {

    private Integer id;
    private String name;
    private int age;
    private Map<String, String> personalInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Map<String, String> personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Person() {
        // TODO Auto-generated constructor stub
    }

    public Person(Integer id, String name, int age, Map<String, String> personalInfo) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.personalInfo = personalInfo;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", personalInfo=" + personalInfo + "]";
    }

}
