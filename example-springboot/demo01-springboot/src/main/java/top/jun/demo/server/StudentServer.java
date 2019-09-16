package top.jun.demo.server;

import top.jun.demo.domain.Student;

import java.util.List;

public interface StudentServer {

    int addOne(Student student);

    void deleteById(int id);

    void upDate(String name, int id);

    List<Student> findAll();

    Student findOneById(int id);




}
