package com.gainsight.spboot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name = "name")
    private String name;
    @Column
    private String mobile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Course", joinColumns = @JoinColumn(name = "name"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> lco;

    public List<Course> getLco() {
        return lco;
    }

    public void setLco(List<Course> lco) {
        this.lco = lco;
    }


    Student() {
    }

    public Student(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
