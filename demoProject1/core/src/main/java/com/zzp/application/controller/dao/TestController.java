package com.zzp.application.controller.dao;


import com.zzp.application.domain.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzp
 * @since 2020-05-18
 */
@Controller
@RequestMapping("/test")
@Api("test表接口")
public class TestController {

    @Autowired
    TestService service;

    @GetMapping("all")
    @ApiOperation("获取所有数据")
    public Object list(){
        return service.list();
    }

}
