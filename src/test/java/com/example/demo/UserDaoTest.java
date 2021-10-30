package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
//自动引入，能够根据接口创建类并创建对象
import org.springframework.beans.factory.annotation.Autowired;
//自动开启事务，无需使用transaction begin，end
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * com.example.demo
 *
 * @author xzwnp
 * 2021/10/23
 * 16:30
 * @Description ：
 * Steps：
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;
    @Test
    public void saveTest(){
        User u = new User();
        u.setId("1213234");
        u.setName("卢本伟");
        u.setAge(19);
        u.setSex(true);
        userDao.save(u);

    }
    @Test
    public void updateTest(){
        User u = new User();
        u.setId("1213234");
        u.setName("芦苇");
        u.setPassword("1234242");
        u.setAge(19);
        u.setSex(true);
        userDao.save(u);

    }

    @Test
    public void InsertUsersTest(){
        List<User> users = new ArrayList<>();
        User u1 = new User("1213235","1adada","卢姥爷",true,10);
        User u2 = new User("1213236","1433223","迪卢克",true,10);
        User u3 = new User("1213237","1433223","锅巴",true,10);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        userDao.saveAll(users);
    }
    @Test
    public void findAllTest(){
        List<User> users = userDao.findAll();
        System.out.println(users);
    }
    @Test
    public void login(){
        User u = userDao.findByIdAndPassword("1213237","1433223");
        System.out.println(u.getName());
    }
    @Test
    public void findByAge(){
        List<User> list= userDao.findUsersByAgeGreaterThan(18);
        for (User u:list
             ) {
            System.out.println(u.getName());
        }
    }
    @Test
    public void findByAge2(){
        List<User> list= userDao.findUsersByAgeLarger(18);
        Iterator<User> iterator = list.iterator();
        for (User u:list
             ) {
            System.out.println(u.getName());
        }
    }
    @Test
    public void updateByName(){
        userDao.updateUserNameById("1213237","卢卢伯爵");

    }
}
