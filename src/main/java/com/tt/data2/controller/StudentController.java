package com.tt.data2.controller;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * @作者：Shilinzhi
 * @时间：2018/11/21 14:54
 * @描述：学生的控制器，负责学生的增删改查
 */
@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    //1.添加年级信息的方法
    @RequestMapping("/addGrade")
    public String addGrade() {
        Grade grade = new Grade();
        grade.setGradeName("第一学期");
        studentService.addGrade(grade);
        return "ok";
    }

    //2.删除年级信息
    @RequestMapping("/deleteGrade")
    public String deleteGrade(@RequestParam Integer gradeID) {
        studentService.deleteGrade(gradeID);
        return "ok";
    }

    //3.查询年级信息的方法
    //http://localhost:8080/findGrade
    @RequestMapping("/findGrade")
    @ResponseBody
    public Object findGrade() {
        List<Grade> list = studentService.findGrade();
        return list;
    }

    //4.查询年级信息的方法
    //http://localhost:8080/findGradeByID?gradeID=7
    @RequestMapping("/findGradeByID")
    @ResponseBody
    public Object findGradeByID(@RequestParam Integer gradeID) {

        Optional<Grade> list = studentService.findGradeByID(gradeID);
        return list;
    }

    //5.获取个数
    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount() {
        int count = studentService.getCount();
        return count;
    }

    //6.根据ID进行排序
    //findGradeBySort
    @RequestMapping("/findGradeBySort")
    @ResponseBody
    public Object findGradeBySort() {
        //排序，你需要告诉1.根据哪个条件排序，2.描述怎么排
        Sort sort = new Sort(Sort.Direction.DESC, "gradeID");
        List<Grade> list = studentService.findGradeBySort(sort);
        return list;
    }

    //7.根据ID分页
    @RequestMapping("/findGradeByPage")
    @ResponseBody
    public Object findGradeByPage(@RequestParam Integer pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, 2);
        Page<Grade> page = studentService.findGradeByPage(pageable);
        List<Grade> list = page.getContent();
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("当前页数：" + (page.getNumber() + 1));
        return list;
    }

    //8.根据名称查询学生信息,getStuByName
    @RequestMapping("/getStuByName")
    @ResponseBody
    public Object getStuByName(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByName(studentName);
        return list;
    }

    //9.根据密码查询学生信息,getStuByPwd
    @RequestMapping("/getStuByPwd")
    @ResponseBody
    public Object getStuByPwd(@RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByPwd(loginPwd);
        return list;
    }

    //10.根据密码查询学生信息,getStuByNoAndPwd
    @RequestMapping("/getStuByNoAndPwd")
    @ResponseBody
    public Object getStuByNoAndPwd(@RequestParam Integer studentNo, @RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByNoAndPwd(studentNo, loginPwd);
        return list;
    }

    //11.根据名称进行模糊查询查询学生信息,getStuByNameLike
    @RequestMapping("/getStuByNameLike")
    @ResponseBody
    public Object getStuByNameLike(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLike(studentName);
        return list;
    }

    //12.根据名称进行模糊查询学生信息并且以学号降序排序,getStuByNameLikeSrot
    @RequestMapping("/getStuByNameLikeSort")
    @ResponseBody
    public Object getStuByNameLikeSort(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLikeSort(studentName);
        return list;
    }

    //13.使用@Query查询所有学生信息， getStudentAll,返回json数据
    @RequestMapping("/getStudentAll")
    @ResponseBody
    public Object getStudentAll() {
        List<Student> list = studentService.getStudentAll();
        return list;
    }

    //14.修改学生信息
    @RequestMapping("/updateStudent")
    public Object updateStudent() {
        Integer studentNo = 1;
        String loginPwd = "666";
        String studentName = "admin";
        studentService.updateStudent(studentNo, loginPwd, studentName);
        return "ok";
    }

    //15.删除学生信息

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Integer studentNo) {
        studentService.deleteStudent(studentNo);
        return "ok";
    }

    //16.根据学号和密码查询学生信息
    @RequestMapping("/getStudentByNoPwd")
    public Object getStudentByNoPwd(@RequestParam Integer studentNo, @RequestParam String loginPwd) {
        List<Student> list = studentService.getStudentByNoPwd(studentNo, loginPwd);
        return list;
    }
}
