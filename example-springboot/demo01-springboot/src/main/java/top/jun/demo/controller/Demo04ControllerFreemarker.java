package top.jun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jun.demo.domain.User;

@Controller//@Controller此处不能是@RestController，因为返回String的是页面地址，而不是将String写入HTTP Response Body
@RequestMapping("/demo04")//指定该Controller使用的freemarker的模板引擎
public class Demo04ControllerFreemarker {

    @Autowired
    private User user;

    @Value("${web.file.path}")//@Value获取配置文件中的配置信息
    private String filePath;

    @GetMapping("/index")
    public String index(){
        return "index";
        //不用加前缀,在置文件application.properties已经配置前缀spring.freemarker.template-loader-path=classpath:/templates/fm/
        //不用加后缀,在配置文件application.properties已经配置后缀信息spring.freemarker.suffix=.ftl
    }


    @GetMapping("/user")
    public String user(ModelMap modelMap){// 将数据存储ModelMap modelMap，页面就能拿到相应的信息
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("filePath", filePath);
        return "user/user";
        //不用加前缀,在置文件application.properties已经配置前缀spring.freemarker.template-loader-path=classpath:/templates/fm/
        //不用加后缀,在配置文件application.properties已经配置后缀信息spring.freemarker.suffix=.ftl
    }

}
