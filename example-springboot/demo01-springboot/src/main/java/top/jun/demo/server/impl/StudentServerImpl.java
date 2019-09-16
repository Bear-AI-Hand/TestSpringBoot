package top.jun.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jun.demo.domain.Student;
import top.jun.demo.mapper.StudentMapper;
import top.jun.demo.server.StudentServer;

import java.util.List;

@Service//@Server注解是将Server的实现类注入Spring容器，以便在Controller中可以获取其实例
public class StudentServerImpl implements StudentServer {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addOne(Student student) {
        studentMapper.addOne(student);
        int id = student.getId();
        return id;
    }

    @Override
    public void deleteById(int id) {
        studentMapper.delete(id);
    }

    @Override
    public void upDate(String name,int id) {
        studentMapper.update(name, id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> all = studentMapper.getAll();
        return all;
    }

    @Override
    public Student findOneById(int id) {
        Student student = studentMapper.findOneById(id);
        return student;
    }
}
