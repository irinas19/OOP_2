package ru.gb.oopseminar.controller;

import ru.gb.oopseminar.data.*;
import ru.gb.oopseminar.service.StudyGroupService;
import ru.gb.oopseminar.service.UserService;
import ru.gb.oopseminar.view.UserView;
import ru.gb.oopseminar.view.StudyGroupView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UserController {

    private final UserService userService = new UserService();

    private final UserView userView = new UserView();

    private final StudyGroupService studyGroupService = new StudyGroupService();

    private final StudyGroupView studyGroupView = new StudyGroupView();

    public void createStudent(String firstName, String lastName, String patronymic) {
        this.userService.createStudent(firstName, lastName, patronymic);
        List<User> users = this.userService.getAll();
        this.userView.sendOnConsole(users);
    }

    public List<Student> getAllStudents() {
        return userService.getAllStudents();
    }

    public void createTeacher(String firstName, String lastName, String patronymic) {
        this.userService.createTeacher(firstName, lastName, patronymic);
        List<User> users = this.userService.getAll();
        this.userView.sendOnConsole(users);
    }

    public List<Teacher> getAllTeachers() {
        return userService.getAllTeachers();
    }

    public void deleteAllUsers() {
        this.userService.deleteAllUsers();
    }

    public void createStudyGroup() {
        Long studyGroupID = this.studyGroupService.getStudyGroupMaxID();
        studyGroupID ++;
        List<Teacher> teachers = this.userService.getAllTeachers();
        Teacher teacherForGroup = null;

        for (Teacher teacher : teachers) {
            if (teacher.getStudyGroupID().equals(-1L)) {
                teacher.setStudyGroupID(studyGroupID);
                teacherForGroup = teacher;
            }
        }
        if (teacherForGroup == null) {
            throw new IllegalStateException("Teacher not found for creating a StudyGroup");
        }

        List<Student> students = this.userService.getAllStudents();
        List<Student> studentsForGroup = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudyGroupID().equals(-1L)) {
                student.setStudyGroupID(studyGroupID);
                studentsForGroup.add(student);
            }
        }
        if (studentsForGroup.isEmpty()) {
            throw new IllegalStateException("Students not found for creating a StudyGroup");
        }

        this.studyGroupService.createStudyGroup(teacherForGroup, studentsForGroup);
        this.studyGroupView.sendOnConsole(this.studyGroupService.getStudyGroups());
    }

    public List<StudyGroup> getAllStudyGroups() {
        return this.studyGroupService.getStudyGroups();
    }

    public void showSortStudyGroup (List<Student> students) {
        Collections.sort(students, new StudentComparator());
        this.userView.showStudents(students);
    }

    public void showSortedStudents (List<StudyGroup> studyGroups) {
        List<Student> students = new ArrayList<>();
        for (StudyGroup studyGroup : studyGroups) {
            students.addAll(studyGroup.getStudents());
        }
        Collections.sort(students, new StudentComparator());
        this.userView.showStudentsWithGroup(students);
    }
}