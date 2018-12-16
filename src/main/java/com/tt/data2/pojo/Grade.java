package com.tt.data2.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeID;
    private String gradeName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class)
    private List<Student> list;

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
