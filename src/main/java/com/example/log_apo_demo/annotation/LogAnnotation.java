package com.example.log_apo_demo.annotation;

import java.lang.annotation.*;

/**
 * 标注哪个方法需要注解
 */


//范围
@Target(ElementType.METHOD)
//运行机制
@Retention(RetentionPolicy.RUNTIME)
//标记该注解在生成的文档中应该包含在注解描述中。
@Documented
public @interface LogAnnotation {
//    注解后的默认值
    String value() default "";
}
