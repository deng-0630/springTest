package com.bdqn.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Aspect
@Component
public class CaculateAspect {
    @Before("execution(* *com.bdqn.test.CaculateImpl.*(..))")
    public void addMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("前置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }

    //后置通知 无论方法是否有异常都会执行，相当于finally块的通知，不一定能获取返回值
    @After("execution(* *com.bdqn.test.CaculateImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("后置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }

    //返回通知可以获取方法返回值
    @AfterReturning(value = "execution(* *com.bdqn.test.CaculateImpl.*(..))",returning = "param")
    public void afterreturnMethod(JoinPoint joinPoint,Object param){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("返回通知：方法名：%s，参数列表：%s,返回值是：%s",mname, Arrays.asList(args),param));
    }

    //异常通知可以获取方法抛出的异常,可以指定特定的异常类型
    @AfterThrowing(value = "execution(* *com.bdqn.test.CaculateImpl.*(..))",throwing = "ex")
    public void afterreturnMethod(JoinPoint joinPoint,ArithmeticException ex){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("异常通知：方法名：%s，参数列表：%s,异常信息是：%s",mname, Arrays.asList(args),ex));
    }

}
