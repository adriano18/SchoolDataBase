package com.company.entities;

/**
 * Created by AdrianP on 10.06.2017.
 */
public class Subject {
    private String teacherNr;
    private String subject;
    private String subjectDescription;

    public Subject(String teacherNr, String subject, String subjectDescription) {
        this.teacherNr = teacherNr;
        this.subject = subject;
        this.subjectDescription = subjectDescription;
    }

    public String getTeacherNr() {
        return teacherNr;
    }

    public String getSubject() {
        return subject;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }
}
