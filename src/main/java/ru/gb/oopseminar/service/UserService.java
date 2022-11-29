package ru.gb.oopseminar.service;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.Teacher;
import ru.gb.oopseminar.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements DataService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    @Override
    public void createStudent(String firstName, String lastName, String patronymic) {
        Long studentID = 0L;
        for (User user : this.users) {
            if (user instanceof Student) {
                if (studentID < ((Student) user).getStudentID()) {
                    studentID = ((Student) user).getStudentID();
                }
            }
        }
        studentID ++;
        this.users.add(new Student(firstName, lastName, patronymic, studentID));
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (User user : this.users) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    @Override
    public void createTeacher(String firstName, String lastName, String patronymic) {
        Long teacherID = 0L;
        for (User user : this.users) {
            if (user instanceof Teacher) {
                if (teacherID < ((Teacher) user).getTeacherID()) {
                    teacherID = ((Teacher) user).getTeacherID();
                }
            }
        }
        teacherID ++;
        this.users.add(new Teacher(firstName, lastName, patronymic, teacherID));
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (User user : this.users) {
            if (user instanceof Teacher) {
                teachers.add((Teacher) user);
            }
        }
        return teachers;
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public void deleteStudent(Long id) {
        for (User user : this.users) {
            if (user instanceof Student) {
                if (id.equals(((Student) user).getStudentID())) {
                    this.users.remove(user);
                }
            }
        }
    }

    @Override
    public void deleteTeacher(Long id) {
        for (User user : this.users) {
            if (user instanceof Teacher) {
                if (id.equals(((Teacher) user).getTeacherID())) {
                    this.users.remove(user);
                }
            }
        }
    }

    public void deleteAllUsers() {
        this.users = new ArrayList<>();
    }
}