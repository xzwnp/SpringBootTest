package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

/**
 * com.example.demo.dao
 *
 * @author xzwnp
 * 2021/10/23
 * 16:24
 * @Description ：
 * Steps：
 */
//无需写实现操作，继承的父类都有声明
@Repository
public interface IUserDao extends JpaRepository<User,String> {
    User findByIdAndPassword(String id,String password);
    List<User> findUsersByAgeGreaterThan(int age);
    @Modifying
    @Transactional //使用@Transactional是为了保证这个方法中的所有操作要么同时成功，要么同时失败
    @Query("update User u set u.name = :name where u.id = :id")
    int updateUserNameById(@Param("id") String userid, @Param("name") String name);

    @Query("select u from User u where u.age >= :age")
    List<User> findUsersByAgeLarger(@Param("age")int age);

}
