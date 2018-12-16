package com.tt.data2.service.impl;

import com.tt.data2.dao.StudentDao;
import com.tt.data2.dao.StudentDao2;
import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @作者：Shilinzhi
 * @时间：2018/11/21 14:55
 * @描述：学生业务层，负责接收控制层请求，找数据访问层帮忙
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;

    @Autowired
    @Qualifier("studentDao2")
    private StudentDao2 studentDao2;

    @Transactional
    public void addGrade(Grade grade) {
        studentDao.save(grade);
    }

    @Transactional
    public void deleteGrade(Integer gradeID) {
        studentDao.deleteById(gradeID);
    }


    @Override
    public List<Grade> findGrade() {
        return (List<Grade>) studentDao.findAll();
    }

    @Override
    public Optional<Grade> findGradeByID(Integer gradeID) {
        return studentDao.findById(gradeID);
    }

    @Override
    public int getCount() {
        return (int) studentDao.count();
    }

    @Override
    public List<Grade> findGradeBySort(Sort sort) {
        return (List<Grade>) studentDao.findAll(sort);
    }

    @Override
    public Page<Grade> findGradeByPage(Pageable pageable) {
        return (Page<Grade>) studentDao.findAll(pageable);
    }

    @Override
    public List<Student> getStuByName(String studentName) {
        return studentDao2.findStudentByStudentName(studentName);
    }

    @Override
    public List<Student> getStuByPwd(String loginPwd) {
        return studentDao2.findStudentByLoginPwd(loginPwd);
    }

    @Override
    public List<Student> getStuByNoAndPwd(Integer studentNo, String loginPwd) {
        return studentDao2.findStudentByStudentNoAndLoginPwd(studentNo, loginPwd);
    }

    @Override
    public List<Student> getStuByNameLike(String studentName) {
        return studentDao2.findStudentByStudentNameLike("%" + studentName + "%");
    }

    @Override
    public List<Student> getStuByNameLikeSort(String studentName) {
        return studentDao2.findStudentByStudentNameLikeOrderByStudentNoDesc("%" + studentName + "%");
    }

    @Override
    public List<Student> getStudentAll() {
        return studentDao2.getStudentAll();
    }

    @Transactional
    public void updateStudent(Integer studentNo, String loginPwd, String studentName) {
        studentDao2.updateStudent(studentNo, loginPwd, studentName);
    }

    @Override
    public List<Student> getStudentByNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.getStudentByNoPwd(studentNo, loginPwd);
    }

    @Transactional
    public void deleteStudent(Integer studentNo) {
        studentDao2.deleteStudent(studentNo);
    }


}
