package com.jchhh.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student implements Person {

    private Integer sid;

    private String sname;

    private Integer age;

    private String gender;

    private Double score;

    private Clazz clazz;

    private String[] hobby;

    private Map<String, Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer sid, String sname, Integer age, String gender, Double score) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public Student(Integer sid, String sname, Integer age, String gender, Double score, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.clazz = clazz;
    }

    public Student(Integer sid, String sname, Integer age, String gender, Double score, Clazz clazz, String[] hobby) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.clazz = clazz;
        this.hobby = hobby;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public Integer getSid() {
        return sid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", teacherMap=" + teacherMap +
                '}';
    }

}
