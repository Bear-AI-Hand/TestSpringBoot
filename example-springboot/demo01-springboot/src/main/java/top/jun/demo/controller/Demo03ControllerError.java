package top.jun.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jun.demo.domain.MyCustomException;

/**
 * 测试异常拦截器
 */

@Controller
@RequestMapping("/demo03")
public class Demo03ControllerError {

    private int result;

    @GetMapping("/myexception")
    public Object myexc(){
        try {
            result = 1/0;
        }catch (Exception e){
            throw new MyCustomException("404", e.getMessage());
        }
        return result;
    }

}
