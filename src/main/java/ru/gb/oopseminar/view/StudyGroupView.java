package main.java.ru.gb.oopseminar.view;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.StudyGroup;
import ru.gb.oopseminar.data.Teacher;

import java.util.List;
import java.util.logging.Logger;

public class StudyGroupView {

    public void sendOnConsole(StudyGroup studyGroup) {
        Logger log = Logger.getLogger(StudyGroupView.class.getName());
        Teacher teacher = studyGroup.getTeacher();
        List<Student> students = studyGroup.getStudents();
        log.info("StudyGroup[" + teacher.toString() + "]");
        for (Student student : students) {
            log.info("StudyGroup[" + student.toString() + "]");
        }
    }
}