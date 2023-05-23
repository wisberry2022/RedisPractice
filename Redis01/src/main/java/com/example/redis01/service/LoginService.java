package com.example.redis01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final StringRedisTemplate stringRedisTemplate;

    public void setToken(String id, String pwd) {
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        vo.set(id, pwd);
    }

    public void getUser(String id) {
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        String val = vo.get(id);
        System.out.println(val);
    }

}
