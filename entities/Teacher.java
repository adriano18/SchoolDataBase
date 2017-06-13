package com.company.entities;

/**
 * Created by AdrianP on 10.06.2017.
 */
public class Teacher {
    private String nameTeacher;
    private String surnameTeacher;
    private String sexTeacher;
    private String birthDayTeacher;

    public Teacher(String nameTeacher, String surnameTeacher, String sexTeacher, String birthDayTeacher) {
        this.nameTeacher = nameTeacher;
        this.surnameTeacher = surnameTeacher;
        this.sexTeacher = sexTeacher;
        this.birthDayTeacher = birthDayTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public String getSurnameTeacher() {
        return surnameTeacher;
    }

    public String getSexTeacher() {
        return sexTeacher;
    }

    public String getBirthDayTeacher() {
        return birthDayTeacher;
    }

}
