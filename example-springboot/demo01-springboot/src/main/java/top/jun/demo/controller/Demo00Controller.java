package top.jun.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * SpringBoot的hello world
 */

@Controller//控制器类，在spring项目中由控制器负责接收用户发来的url请求,并转发到对应的服务接口（service层）
@RequestMapping("/demo00")
public class Demo00Controller {

    @GetMapping("/helloworld")//跳转路径
    @ResponseBody//@ResponseBody将返回结果直接写入HTTP Response Body中
    public String helloWorld(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        return "Hello World SpringBoot!";
    }

}
