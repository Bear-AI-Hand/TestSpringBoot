package top.jun.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.jun.demo.domain.MyCustomException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常拦截器
 *
 */

@RestControllerAdvice
public class MyCustomExceptionHandler {

    //异常拦截器：监听spring容器中出现的异常 ，当发生异常的时候就会捕获异常，执行下面的方法
    @ExceptionHandler(value = MyCustomException.class)
    public Object handleMyExeception(MyCustomException e, HttpServletRequest httpServletRequest){
        //方式一：页面请求后，后端出现异常，前端页面跳转
        /*
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg", exception.getMessage());
        return modelAndView;
        */
        //方式二：页面请求后，后端出现异常，返回json给前端由前端进行处理
        Map map = new HashMap<String, Object>();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        map.put("url", httpServletRequest.getRequestURL());
        return map;
    }
}
