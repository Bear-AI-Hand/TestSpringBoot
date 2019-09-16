package top.jun.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jun.demo.domain.Student;
import top.jun.demo.server.StudentServer;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/demo06")
public class Demo06ControllerMybatis {

    @Autowired
    private StudentServer studentServer;

    //增加(Student:{name=zhangsan,age=18,phone=110,createTime=new Date()})
    @GetMapping("/add")
    public Student addStudent(){
        Student student = new Student();
        student.setName("no_transactional_@");
        student.setAge(18);
        student.setPhone("110");
        student.setCreateTime(new Date());
        studentServer.addOne(student);
        int i = 1/0;
        return student;
    }

    //删除id=22的Student的用户
    @GetMapping("/delete_one_by_id")
    public void deleteOneById(){
        int id = 22;
        studentServer.deleteById(id);
    }

    //修改id=23的Student的name为baidu
    @GetMapping("/update")
    public void update(){
        int id = 23;
        String name = "baidu";
        studentServer.upDate(name,id);
    }

    //查询所有Student
    @GetMapping("find_all")
    public List<Student> findAll(){
        List<Student> all = studentServer.findAll();
        return all;
    }

    //通过id查询Student
    @GetMapping("find_by_Id")
    public Student findById(){
        int id = 20;
        Student student = studentServer.findOneById(id);
        return student;
    }


    //测试事务(未增加事务控制)
    @GetMapping("/noTransactional")
    public Student noTransactional(){
        Student student = new Student();
        student.setName("no_transactional");
        student.setAge(18);
        student.setPhone("110");
        student.setCreateTime(new Date());
        studentServer.addOne(student);
        int i = 1/0;
        return student;
    }

    //测试事务(增加事务控制)
    @GetMapping("/haveTransactional")
    @Transactional(propagation = Propagation.REQUIRED)
    public Student haveTransactional(){
        Student student = new Student();
        student.setName("have_transactional");
        student.setAge(18);
        student.setPhone("110");
        student.setCreateTime(new Date());
        studentServer.addOne(student);
        int i = 1/0;
        return student;
    }


}
