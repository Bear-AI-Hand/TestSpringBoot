package top.jun.demo.domain;

import java.io.Serializable;

/**
 * 自定义异常类
 */

public class MyCustomException extends RuntimeException implements Serializable {

    private String code;
    private String msg;
    public MyCustomException() {
    }
    public MyCustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Override
    public String toString() {
        return "MyExeception{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
