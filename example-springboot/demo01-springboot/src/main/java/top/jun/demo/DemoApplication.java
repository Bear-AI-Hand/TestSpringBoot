package top.jun.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 不要直接在src/main/java下直接编写启动的Application
 */

//@SpringBootApplication//一个注解顶下面三个注解
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan//该注解扫描该类同级目录和子级目录下的java文件，但是这个包下不是全部类都是要被spring管理，对应的类加了注解才是会被spring管理
//@ServletComponentScan//扫描Servlet
@MapperScan("top.jun.demo.mapper")//扫描mapper层包
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
