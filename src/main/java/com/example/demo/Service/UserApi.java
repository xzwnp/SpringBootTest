package com.example.demo.Service;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * com.example.demo.Service
 *
 * @author xzwnp
 * 2021/10/30
 * 15:05
 * @Description ：
 * Steps：
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    //接口无法创建对象，需要借助注解
    @Autowired
    private IUserDao userDao;

    @GetMapping(value = "/login/{id}/{password}")
    public String Login(@PathVariable String id, @PathVariable String password) {
        User u = userDao.findByIdAndPassword(id, password);
        return u.getName() + u.getAge();
    }

    @PostMapping("/login")
    public String loginByIdandPassword(@RequestParam String id, @RequestParam String password) {
        User u = userDao.findByIdAndPassword(id, password);
        if (u == null) {
            return "Please login in first!";
        } else {
            return "Welcome" + u.getName();
        }
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String id, @RequestParam String name, @RequestParam String password,@RequestParam boolean sex,@RequestParam int age) {
        if (id == null){
            return "please complete the Id of the user!";
        }
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setPassword(password);
        u.setSex(sex);
        u.setAge(age);
        try {
            userDao.save(u);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "创建成功";
    }
    @PostMapping("/register2")
    public String registerUser2(@RequestBody User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "创建成功";
    }
    @PostMapping("/update")
    public String update(@RequestBody User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "修改成功";
    }
    @PostMapping("delete")
    public String delete(@RequestParam String id){
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "删除成功！";
    }

}
