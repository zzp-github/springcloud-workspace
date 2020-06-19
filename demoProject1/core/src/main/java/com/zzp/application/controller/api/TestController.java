package com.zzp.application.controller.api;


import com.zzp.application.domain.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzp
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/api")
@Api("test表接口")
public class TestController {

    @Autowired
    TestService service;

    @GetMapping("/listAll")
    @ApiOperation("获取所有数据")
    public Object list(){
        return service.list();
    }

}
