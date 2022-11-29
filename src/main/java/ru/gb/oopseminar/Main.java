
package ru.gb.oopseminar;

import ru.gb.oopseminar.controller.UserController;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();

        controller.createTeacher("Ivan", "Ivanov", "Ivanovich");
        controller.createStudent("Petr", "Petrov", "Petrovich");
        controller.createStudent("Vasiliy", "Valilieyv", "Vasilieyvich");
        controller.createStudyGroup();

        controller.createTeacher("Petr", "Ivanov", "Vasilieyvich");
        controller.createStudent("Ivan", "Vasilieyv", "Petrovich");
        controller.createStudent("Vasiliy", "Petrov", "Ivanovich");
        controller.createStudyGroup();

        controller.createTeacher("Kirill", "Alekseev", "Andreyvich");
        controller.createStudent("Vadim", "Volodin", "Maksimovich");
        controller.createStudent("Denis", "Ryabtsev", "Igoryvich");
        controller.createStudyGroup();

        controller.showSortedStudents(controller.getAllStudyGroups());
    }
}