package com.zzp.application.controller.redisApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * message
 *
 * @author: zzp
 * @date: 2020/04/30/17:36
 */
@RestController
@Api("测试接口")
@RequestMapping("/redisApi")
public class RedisApiController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    JedisPool jedisPool;

    @PostMapping("/saveString")
    @ApiOperation("测试接口1")
    public boolean saveString(@ApiParam(value = "姓名")@RequestParam String name){
        System.out.println(name);
//        redisTemplate.boundValueOps("test").set(name, 10);

        //String类型，加过期时间
        redisTemplate.opsForValue().set("testTime", "设置10s缓存", 10, TimeUnit.SECONDS);

        Map<String, String> map = new HashMap<>();
        //map类型
        redisTemplate.opsForHash().putAll("map", map);
        //设置某个key的过期时间
        redisTemplate.expire("map", 10, TimeUnit.SECONDS);
        return true;
    }


    @GetMapping("/getString")
    @ApiOperation("测试接口1")
    public String getString(@ApiParam(value = "姓名")@RequestParam("name") String name){
        String test = redisTemplate.boundValueOps("testTime").get();
        if (StringUtils.isNotBlank(test)){
            return test;
        }
        return "无数据";
    }

    @GetMapping("/jedis/setValue")
    @ApiOperation("测试接口1")
    public String jedisSetValue(@ApiParam(value = "姓名")@RequestParam("name") String name){
        String test = redisTemplate.boundValueOps("testTime").get();
        if (StringUtils.isNotBlank(test)){
            return test;
        }
        return "无数据";
    }

}
