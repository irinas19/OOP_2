package main.java.ru.gb.oopseminar.data;

public class Student extends User {
    private Long studentID;

    public Student(String firstName, String lastName, String patronymic, Long studentID) {
        super(firstName, lastName, patronymic);
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", patronymic='" + super.getPatronymic() + '\'' +
                ", studentID=" + studentID +
                '}';
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
}