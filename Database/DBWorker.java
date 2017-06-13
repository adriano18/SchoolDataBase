package com.company.Database;

import com.company.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdrianP on 09.06.2017.
 */
public class DBWorker {
    public String authentication(String login, String password) {

        String userLogin = "";
        String userPassword = "";

        try(Connection conn = Connector.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM users" +  " WHERE login = ? AND password = ?")
        )
        {
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                userLogin = rs.getString("login");
                userPassword = rs.getString("password");
            }
            rs.close();
            if (!userLogin.isEmpty() && userPassword.isEmpty()) {
                if (userLogin.equals(login) && userPassword.equals(password)) {
                    return "successful";
                } else {
                    return "incorrect login or password";
                }
            } else {
                return "user and password not be null";
            }

        } catch (SQLException e) {
            return "sql error\n" + e.getMessage();
        } catch (ClassNotFoundException e) {
            return "global error";
        }
    }

    public List<Student> showStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
        PreparedStatement pstStudent = connection.prepareStatement("SELECT * FROM students")) {
            ResultSet rsStudent = pstStudent.executeQuery();

            while (rsStudent.next()) {
                students.add(new Student(rsStudent.getString("Name"), rsStudent.getString("Surname"), rsStudent.getString("Sex"), rsStudent.getString("Birth_Day"), rsStudent.getString("Course")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Lesson> showLesson() {
        List<Lesson> lessons = new ArrayList<>();
        try(Connection connection = Connector.getConnection();
        PreparedStatement pstSubject = connection.prepareStatement("SELECT * FROM lessons")) {
            ResultSet rsSubject = pstSubject.executeQuery();

            while (rsSubject.next()) {
                lessons.add(new Lesson(rsSubject.getString("Lesson_Nr"), rsSubject.getString("Topic"), rsSubject.getString("Subject"), rsSubject.getString("Desciption"), rsSubject.getString("Teacher"), rsSubject.getString("Course")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public List<Teacher> showTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
        PreparedStatement pstTeacher = connection.prepareStatement("SELECT * FROM teachers")) {
            ResultSet rsTeacher = pstTeacher.executeQuery();

            while (rsTeacher.next()) {
                teachers.add(new Teacher(rsTeacher.getString("Name"), rsTeacher.getString("Surname"), rsTeacher.getString("Sex"), rsTeacher.getString("Birth_Day")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public List<Journal> showJournal() {
        List<Journal> journalList = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
        PreparedStatement pstJournal = connection.prepareStatement("SELECT * FROM journal")) {
            ResultSet rsJournal = pstJournal.executeQuery();

            while (rsJournal.next()) {
                journalList.add(new Journal(rsJournal.getString("Date"), rsJournal.getString("Subject"), rsJournal.getString("Lesson_Nr"), rsJournal.getString("Teacher"), rsJournal.getString("Student"), rsJournal.getString("Student_rating")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return journalList;
    }

    public List<Subject> showSubject() {
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
        PreparedStatement pstSubject = connection.prepareStatement("SELECT * FROM subjects")) {
            ResultSet rsSubject = pstSubject.executeQuery();

            while (rsSubject.next()) {
                subjects.add(new Subject(rsSubject.getString("Teacher_Nr"), rsSubject.getString("Subject"), rsSubject.getString("Description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}
