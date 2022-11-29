package ru.gb.oopseminar.data;

public class Teacher extends User {
    private Long teacherID;

    public Teacher(String firstName, String lastName, String patronymic, Long teacherID) {
        super(firstName, lastName, patronymic);
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        if (super.getStudyGroupID().equals(-1L)) {
            return "Teacher{" +
                    "firstName='" + super.getFirstName() +
                    "', lastName='" + super.getLastName() +
                    "', patronymic='" + super.getPatronymic() +
                    "', teacherID=" + teacherID +
                    "}";
        } else {
            return "Teacher{" +
                    "firstName='" + super.getFirstName() +
                    "', lastName='" + super.getLastName() +
                    "', patronymic='" + super.getPatronymic() +
                    "', teacherID=" + teacherID +
                    "', studyGroupID=" + super.getStudyGroupID() +
                    "}";
        }
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }
}