package com.example.log_apo_demo.aspect;

import com.example.log_apo_demo.annotation.LogAnnotation;
import lombok.With;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 1. @ClassName LogAspect
 * 2. @Description 切面类
 * 3. @Author huo
 * 4. @Date 2023/9/21 23:17
 */

//标记他是个注解
@Aspect
//让他IOC注入
@Component
public class LogAspect {

    /**
     * 找切点位置
     */
//    注解+全类名
    @Pointcut("@annotation(com.example.log_apo_demo.annotation.LogAnnotation)")
    public void LogPointCut(){

    }

    /**
     * 切面方法
     * @param point
     * @return
     */
    @Around("LogPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
//    日志输出
        String name = point.getSignature().getName();
//        通过反射获取注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        if (annotation != null){
            String value = annotation.value();
            System.out.println("{##系统日志输出##}当前操作"+value+"执行了"+name+"方法， 返回值是:"+ point.proceed());
        }

        return point.proceed();
    }
}
