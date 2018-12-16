package com.tt.data2.service;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @作者：Shilinzhi
 * @时间：2018/11/21 15:09
 * @描述：业务逻辑层接口
 */
public interface StudentService {

    void addGrade(Grade grade);

    void deleteGrade(Integer gradeID);

    List<Grade> findGrade();

    Optional<Grade> findGradeByID(Integer gradeID);

    int getCount();

    List<Grade> findGradeBySort(Sort sort);

    Page<Grade> findGradeByPage(Pageable pageable);

    List<Student> getStuByName(String studentName);

    List<Student> getStuByPwd(String loginPwd);

    List<Student> getStuByNoAndPwd(Integer studentNo, String loginPwd);

    List<Student> getStuByNameLike(String studentName);

    List<Student> getStuByNameLikeSort(String studentName);

    List<Student> getStudentAll();

    void deleteStudent(Integer studentNo);

    void updateStudent(Integer studentNo, String loginPwd, String studentName);

    List<Student> getStudentByNoPwd(Integer studentNo, String loginPwd);
}
