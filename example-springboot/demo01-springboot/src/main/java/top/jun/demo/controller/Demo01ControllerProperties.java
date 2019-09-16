package top.jun.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jun.demo.domain.User;

/**
 * 需求：
 *  配置信息 -> Spring容器 -> Spring容器中获取到
 *  配置信息 -> JavaBean -> Spring容器
 *
 * 方法：
 * 1.指定properties文件地址@PropertySource({"classpath:resource.properties"})
 * 2.使用@Value("${web.file.path}")将配置信息中的web.file.path注入Spring容器中
 * 3.再从Spring容器中获取值
 *
 */
@RestController// @RestController = @Controller + @ResponseBody, 因为@RestController中已经含有@ResponseBody，那么下面返回的方法就不需要加@ResponseBody
@PropertySource({"classpath:resource.properties"})//将resource.properties配置文件注入到spring容器中
@RequestMapping("/demo01")
public class Demo01ControllerProperties {

    @Value("${web.file.path}")
    //将配置信息中的resource.properties的web.file.path注入Spring容器->再从Spring容器中获取web.file.path所对应的值赋值给filePath
    private String filePath;

    @Autowired//注入类对象
    //从Spring容器中获取User对象的实例
    private User user;

    @GetMapping("/filePath")
    public String getFilePath(){
        return filePath;
    }


    @GetMapping("/user")
    public Object getUser(){
        return user;
    }

}
