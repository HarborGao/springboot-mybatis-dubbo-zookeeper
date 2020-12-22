package com.harbor.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.harbor.common.domain.User;
import com.harbor.common.service.UserService;
import com.harbor.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0")
public class UserImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findUser(String userName) {
        String key = "user_" + userName;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            System.out.println("从缓存中获得数据："+user.getUserName());
            System.out.println("------------------------------------");
            return user;
        }else{
            User user = userMapper.getOne(userName);
            System.out.println("查询数据库获得数据："+user.getUserName());
            System.out.println("------------------------------------");

            // 写入缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }
    }

    @Override
    public int addUser(User user) {
        Set keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
        return userMapper.addUser(user);
    }
}