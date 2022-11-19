package com.lib.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisUtil {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public Boolean AddRedis(String key,Object obj){
        ValueOperations<String, String> valueOperations=redisTemplate.opsForValue();
        String objStr = JSONObject.toJSONString(obj);
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        valueOperations.set(key,objStr, Duration.ofHours(2));
        return true;
    }

    public String isExistKey(String key){
        ValueOperations<String, String> valueOperations=redisTemplate.opsForValue();
        String str = valueOperations.get(key);
        return str;
    }
}
