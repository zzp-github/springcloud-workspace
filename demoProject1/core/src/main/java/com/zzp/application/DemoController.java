package com.zzp.application;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * message
 *
 * @author: zzp
 * @date: 2020/04/30/17:36
 */
@RestController
@Api("测试接口")
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("test1")
    @ApiOperation("测试接口1")
    public String test(){
        return "你好";
    }
}
