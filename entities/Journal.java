package com.company.entities;

/**
 * Created by AdrianP on 10.06.2017.
 */
public class Journal {
    private String date;
    private String subject;
    private String lessonNr;
    private String teacher;
    private String student;
    private String studentScore;

    public Journal(String date, String subject, String lessonNr, String teacher, String student, String studentScore) {
        this.date = date;
        this.subject = subject;
        this.lessonNr = lessonNr;
        this.teacher = teacher;
        this.student = student;
        this.studentScore = studentScore;
    }

    public String getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public String getLessonNr() {
        return lessonNr;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudent() {
        return student;
    }

    public String getStudentScore() {
        return studentScore;
    }
}
