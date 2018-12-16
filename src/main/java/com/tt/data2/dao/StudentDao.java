package com.tt.data2.dao;

import com.tt.data2.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @作者：Shilinzhi
 * @时间：2018/11/21 15:09
 * @描述：学生的数据访问层，负责对数据库进行操作
 */
public interface StudentDao extends JpaRepository<Grade, Integer> {

}
