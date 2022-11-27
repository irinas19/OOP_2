package ru.gb.oopseminar.controller;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.StudyGroup;
import ru.gb.oopseminar.data.Teacher;
import ru.gb.oopseminar.data.User;
import ru.gb.oopseminar.service.StudyGroupService;
import ru.gb.oopseminar.service.UserService;
import ru.gb.oopseminar.view.UserView;
import ru.gb.oopseminar.view.StudyGroupView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final UserService userService = new UserService();

    private final UserView userView = new UserView();

    private final StudyGroupService studyGroupService = new StudyGroupService();

    private final StudyGroupView studyGroupView = new StudyGroupView();

    public void createStudent(String firstName, String lastName, String patronymic) {
        this.userService.createStudent(firstName, lastName, patronymic);
        List<User> users = this.userService.getAll();
        this.userView.sendOnConsole(users);
    }

    public void createTeacher(String firstName, String lastName, String patronymic) {
        this.userService.createTeacher(firstName, lastName, patronymic);
        List<User> users = this.userService.getAll();
        this.userView.sendOnConsole(users);
    }

    public void createStudyGroup() {
        List<User> users = this.userService.getAll();
        Teacher teacher = null;
        List<Student> students = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Teacher) {
                 teacher = (Teacher) user;
            } else if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        this.studyGroupService.createStudyGroup(teacher, students);
        StudyGroup studyGroup = this.studyGroupService.getStudyGroup();
        this.studyGroupView.sendOnConsole(studyGroup);
    }
}