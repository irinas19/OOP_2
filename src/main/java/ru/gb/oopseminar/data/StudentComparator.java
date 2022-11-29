package ru.gb.oopseminar.data;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getLastName().equalsIgnoreCase(student2.getLastName())) {
            return student1.getFirstName().compareTo(student2.getFirstName());
        }
        return student1.getLastName().compareTo(student2.getLastName());
    }
}