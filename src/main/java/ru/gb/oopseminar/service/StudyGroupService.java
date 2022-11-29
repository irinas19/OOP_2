package ru.gb.oopseminar.service;

import ru.gb.oopseminar.data.Student;
import ru.gb.oopseminar.data.StudyGroup;
import ru.gb.oopseminar.data.Teacher;
import ru.gb.oopseminar.data.User;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {
    private List<StudyGroup> studyGroups;

    public StudyGroupService() {
        this.studyGroups = new ArrayList<>();
    }

    public void createStudyGroup(Teacher teacher, List<Student> students) {
        Long studyGroupID = getStudyGroupMaxID();
        studyGroupID ++;
        this.studyGroups.add(new StudyGroup(teacher, students, studyGroupID));
    }

    public Long getStudyGroupMaxID() {
        Long studyGroupMaxID = 0L;
        for (StudyGroup studyGroup : this.studyGroups) {
            if (studyGroupMaxID < studyGroup.getStudyGroupID()) {
                studyGroupMaxID = studyGroup.getStudyGroupID();
            }
        }
        return studyGroupMaxID;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }
}