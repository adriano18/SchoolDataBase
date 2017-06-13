package com.company.entities;

/**
 * Created by AdrianP on 10.06.2017.
 */
public class Student {
    private String nameStudent;
    private String surnameStudent;
    private String sexStudent;
    private String birthDayStudent;
    private String course;

    public Student(String nameStudent, String surnameStudent, String sexStudent, String birthDayStudent, String course) {
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.sexStudent = sexStudent;
        this.birthDayStudent = birthDayStudent;
        this.course = course;
    }
    public String getNameStudent() {
        return nameStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public String getSexStudent() {
        return sexStudent;
    }

    public String getBirthDayStudent() {
        return birthDayStudent;
    }

    public String getCourse() {
        return course;
    }
}
