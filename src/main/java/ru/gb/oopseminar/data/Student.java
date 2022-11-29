package ru.gb.oopseminar.data;

public class Student extends User {
    private Long studentID;

    public Student(String firstName, String lastName, String patronymic, Long studentID) {
        super(firstName, lastName, patronymic);
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        if (super.getStudyGroupID().equals(-1L)) {
            return "Student{" +
                    "firstName='" + super.getFirstName() +
                    "', lastName='" + super.getLastName() +
                    "', patronymic='" + super.getPatronymic() +
                    "', studentID=" + studentID +
                    "}";
        } else {
            return "Student{" +
                    "firstName='" + super.getFirstName() +
                    "', lastName='" + super.getLastName() +
                    "', patronymic='" + super.getPatronymic() +
                    "', studentID=" + studentID +
                    "', studyGroupID=" + super.getStudyGroupID() +
                    "}";
        }
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
}