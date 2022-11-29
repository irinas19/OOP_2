package ru.gb.oopseminar.data;

public abstract class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Long studyGroupID;

    public User(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.studyGroupID = -1L;
    }

    @Override
    public String toString() {
        if (this.studyGroupID.equals(-1L)) {
            return "User{" +
                    "firstName='" + this.firstName + '\'' +
                    ", lastName='" + this.lastName + '\'' +
                    ", patronymic='" + this.patronymic + '\'' +
                    "}";
        } else {
            return "User{" +
                    "firstName='" + this.firstName +
                    "', lastName='" + this.lastName +
                    "', patronymic='" + this.patronymic +
                    "', studyGroup=" + this.studyGroupID +
                    "}";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getStudyGroupID() {
        return studyGroupID;
    }

    public void setStudyGroupID(Long studyGroup) {
        this.studyGroupID = studyGroup;
    }
}