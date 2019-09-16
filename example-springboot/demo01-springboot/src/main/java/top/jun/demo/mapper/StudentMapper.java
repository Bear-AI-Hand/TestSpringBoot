package top.jun.demo.mapper;

import org.apache.ibatis.annotations.*;
import top.jun.demo.domain.Student;

import java.util.List;

public interface StudentMapper {

    //增
    @Insert("INSERT INTO student(name,phone,create_time,age) values (#{name},#{phone},#{createTime},#{age})")//#{createTime}选择的是JavaBean中的成员变量名称
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addOne(Student student);

    //删
    @Delete("DELETE FROM student WHERE id =#{id}")
    void delete(int id);

    //改
    @Update("UPDATE student SET name=#{name} WHERE id =#{id}")
    void update(String name, int id);

    //查
    @Select("SELECT * FROM student")
    @Results({
            @Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
    })
    List<Student> getAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Student findOneById(int id);

}
