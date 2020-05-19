package com.zzp.application.controller.string;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * message
 *
 * @author: zzp
 * @date: 2020/05/11/10:22
 */
@RestController
@Api("String相关工具接口")
@RequestMapping("/string")
public class StringController {

    @GetMapping("replaceMethod")
    @ApiOperation("字符串替换 - 为 ''")
    public String replaceMethod(@ApiParam(value = "字符串替换 _ 为 ''") @RequestParam String string){
        System.out.println(string);
        return string.replace("_", "");
    }

}
