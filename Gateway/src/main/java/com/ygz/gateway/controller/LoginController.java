package com.ygz.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.lib.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class LoginController {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/login")
    public String addRedis(){
        ValueOperations<String, String> valueOperations=redisTemplate.opsForValue();
        User user=new User().setUId(1).setUName("123");
        String userString = JSONObject.toJSONString(user);
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        valueOperations.set("user:token",userString, Duration.ofHours(2));
      return "ok";
    }
}
