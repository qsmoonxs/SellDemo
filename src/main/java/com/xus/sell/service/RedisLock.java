package com.xus.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 22:16
 */

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key 商品Id
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if(redisTemplate.opsForValue().setIfAbsent(key,value)) {
            return true;
        }

        // currentValue=A 这两个线程value都是B 其中一个线程拿到锁,但是有bug 一个线程拿到锁但是set了另一个值
        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果锁过期
        if(!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            // 获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 上锁 （王启运改造的）
     * @param key
     * @param value
     * @return
     */
    public boolean lock2(String key, String value) {

        redisTemplate.watch(key);
        String v = (String) redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(v) && System.currentTimeMillis() < Long.parseLong(v)) return false;
        redisTemplate.multi();
        redisTemplate.opsForValue().set(key, value);
        List<Object> exec = redisTemplate.exec();
        return exec != null && !exec.isEmpty();
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {

        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {

                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
           log.error("【redis分布式锁解锁异常】,{}",e);
        }

    }
}
