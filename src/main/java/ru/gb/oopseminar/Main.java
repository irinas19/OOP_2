package main.java.ru.gb.oopseminar;

import ru.gb.oopseminar.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createTeacher("Ivan", "Ivanov", "Ivanovich");
        controller.createStudent("Petr", "Petrov", "Petrovich");
        controller.createStudent("Vasiliy", "Valilieyv", "Vasilieyvich");

        controller.createStudyGroup();
    }
}