package top.jun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jun.demo.domain.User;

@Controller
@RequestMapping("/demo05")
public class Demo05ControllerThymeleaf {

    @Autowired
    private User user;

    @Value("${web.file.path}")//@Value获取配置文件中的配置信息
    private String filePath;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("filePath", filePath);
        System.out.println(user);
        System.out.println(filePath);
        return "user/user";
    }

}
