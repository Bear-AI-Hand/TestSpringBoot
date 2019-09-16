package top.jun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jun.demo.domain.JsonData;

import java.util.HashMap;

@RestController
@RequestMapping("/demo07")
public class Demo07ControllerRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/setString")
    public Object setString(@RequestParam("key")String key, @RequestParam("value")String value){
        stringRedisTemplate.opsForValue().set(key, value);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data","ok");
        map.put("code", 0);
        return map;
    }

    @GetMapping("/getString")
    public Object getString(@RequestParam("key")String key){
        String vaule = stringRedisTemplate.opsForValue().get(key);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",vaule);
        map.put("code", 0);
        return map;
    }

}
