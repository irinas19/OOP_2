package ru.gb.oopseminar.service;

import ru.gb.oopseminar.data.User;

import java.util.List;

public interface DataService {
    void createStudent(String firstName, String lastName, String patronymic);

    void createTeacher(String firstName, String lastName, String patronymic);

    List<User> getAll();

    void deleteStudent(Long id);

    void deleteTeacher(Long id);

}