package com.vinay7.aopdemo.annotation;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)//default
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";
}
