package com.zzp.application.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * 切面类
 */
@Slf4j
@Aspect
@Component
public class LogAspect {


    /**
     * 定义切点
     * * com.zzp.application.controller..*.*(..)
     * 拦截包或者子包中定义的方法
     */
    @Pointcut("execution(* com.zzp.application.controller..*.*(..))")
    private void pointCut(){

    }

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param jp
     */
    @Before("pointCut()")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 后置通知
     */
    @After("pointCut()")
    public void after(JoinPoint jp) throws Exception{
        //获得请求的参数
        List<Object> params = Arrays.asList(jp.getArgs());
        System.out.println("====后置通知参数==== params = " + params);
    }

}
