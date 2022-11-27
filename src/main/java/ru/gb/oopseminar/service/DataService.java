package main.java.ru.gb.oopseminar.service;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.Teacher;
import ru.gb.oopseminar.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements DataService {
    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    @Override
    public void createStudent(String firstName, String lastName, String patronymic) {
        Long id = 0L;
        for (User user : this.users) {
            if (user instanceof Student) {
                if (id < ((Student) user).getStudentID()) {
                    id = ((Student) user).getStudentID();
                }
            }
        }
        this.users.add(new Student(firstName, lastName, patronymic, ++id));
    }

    @Override
    public void createTeacher(String firstName, String lastName, String patronymic) {
        Long id = 0L;
        for (User user : this.users) {
            if (user instanceof Teacher) {
                if (id < ((Teacher) user).getTeacherID()) {
                    id = ((Teacher) user).getTeacherID();
                }
            }
        }
        this.users.add(new Teacher(firstName, lastName, patronymic, ++id));
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
}