package com.example.demo.Service;


import org.springframework.web.bind.annotation.*;

/**
 * com.example.demo.Service
 *
 * @author xzwnp
 * 2021/10/23
 * 14:42
 * @Description ：
 * Steps：
 */
@RestController
@RequestMapping("/api/Hello")
public class HelloApi {

    //{}是一个占位符，会把输入的内容直接传入参数String name 中
    @RequestMapping(value = "/says/{name}",method = RequestMethod.GET)
    public String sayName(@PathVariable String name){
        return "你的名字是:"+name;
    }
    @GetMapping(value = "/says2/{name}")
    public String sayName2(@PathVariable String name){
        return "他的名字是:"+name;
    }

}
