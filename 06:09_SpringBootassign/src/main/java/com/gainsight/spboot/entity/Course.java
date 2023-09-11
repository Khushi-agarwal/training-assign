package com.gainsight.spboot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @Column(name="course_id")
    private int courseId;
    @Column(name="course_name")
    private String courseName;
    @Column(name="duration")
    private int duration;
    @Column
    private double fees;
    @ManyToMany(mappedBy = "lco",fetch = FetchType.EAGER)
    List<Student> lstud;

    public List<Student> getLstud() {
        return lstud;
    }

    public void setLstud(List<Student> lstud) {
        this.lstud = lstud;
    }


    Course(){}

    public Course(int courseId, String courseName, int duration, double fees) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
