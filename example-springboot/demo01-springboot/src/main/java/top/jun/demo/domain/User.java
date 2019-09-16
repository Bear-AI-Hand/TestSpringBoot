package top.jun.demo.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component//在Application中配置了@ComponentScan只能保证该类能被扫描到，只有添加@Component，才会将该类注入Spring容器，在其他的类中才能使用@Autowired获取到该类的实例
@PropertySource({"classpath:resource.properties"})////将resource.properties配置文件注入到spring容器中
//@ConfigurationProperties(prefix = "test.user")//通过@ConfigurationProperties(prefix = "test.user"),无需使用@Value注入即可注入,需要成员变量需要非常规范
public class User {

    @Value("${test.user.name}")//将配置信息中的resource.properties的test.user.name注入Spring容器,再从Spring容器中获取test.user.name所对应的值赋值给name
    private String name;

    @Value("${test.user.age}")
    private String age;

    @Value("${test.user.address}")
    private String address;

    public User() {
    }

    public User(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}
