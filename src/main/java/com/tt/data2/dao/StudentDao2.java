package com.tt.data2.dao;

import com.tt.data2.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao2 extends JpaRepository<Student, Integer> {

    List<Student> findStudentByStudentName(String studentName);

    List<Student> findStudentByLoginPwd(String loginPwd);

    List<Student> findStudentByStudentNoAndLoginPwd(Integer studentNo, String loginPwd);

    List<Student> findStudentByStudentNameLike(String studentName);

    List<Student> findStudentByStudentNameLikeOrderByStudentNoDesc(String studentName);

    @Query("select s from Student as s")
    List<Student> getStudentAll();

    //增删改需要进行事务处理，要加一个注解，@ModiFying
    @Modifying
    @Query("update Student set loginPwd=:loginPwd,studentName=:studentName where studentNo=:studentNo")
    void updateStudent(@Param("studentNo") Integer studentNo, @Param("loginPwd") String loginPwd,
                       @Param("studentName") String studentName);

    @Modifying
    @Query("delete from Student where studentNo=?1")
    void deleteStudent(Integer studentNo);

    @Query("select s from Student as s where s.studentNo=?1 and s.loginPwd=?2")
    List<Student> getStudentByNoPwd(Integer studentNo, String loginPwd);
}
