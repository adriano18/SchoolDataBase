package com.company.entities;

/**
 * Created by AdrianP on 10.06.2017.
 */
public class Lesson {
    private String lessonNr;
    private String topic;
    private String subject;
    private String description;
    private String teacher;
    private String course;

    public Lesson(String lessonNr, String topic, String subject, String description, String teacher, String course) {
        this.lessonNr = lessonNr;
        this.topic = topic;
        this.subject = subject;
        this.description = description;
        this.teacher = teacher;
        this.course = course;
    }

    public String getLessonNr() {
        return lessonNr;
    }

    public String getTopic() {
        return topic;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getCourse() {
        return course;
    }
}
