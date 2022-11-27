package main.java.ru.gb.oopseminar.service;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.StudyGroup;
import ru.gb.oopseminar.data.Teacher;

import java.util.List;

public class StudyGroupService {
    private StudyGroup studyGroup;

    public StudyGroupService() {

    }

    public void createStudyGroup(Teacher teacher, List<Student> students) {
        this.studyGroup = new StudyGroup(teacher, students);
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }
}