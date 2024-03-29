package top.jun.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int id;
    private String name;
    private String phone;
    private int age;
    private Date createTime;

    public Student() {
    }

    public Student(int id, String name, String phone, int age, Date createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.createTime = createTime;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", createtime=" + createTime +
                '}';
    }
}
