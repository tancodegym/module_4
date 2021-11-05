package com.codegym.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogBook {
    @Pointcut("within(com.codegym.controller.BookController*)")
    public void allMethod(){

    }
    @Pointcut("execution(* com.codegym.controller.BookController.*Book(..))")
    public void allBookChange(){
    }
    @Around("allBookChange()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("thoi gian truoc khi thay doi so luong sach"+ LocalDateTime.now());
        Object value=null;
        try{
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("thoi gian xay ra loi: " + LocalDateTime.now());
            throwable.printStackTrace();
        }
        System.out.println("thoi gian sau khi thay doi so luong sach" + LocalDateTime.now()+ "Return value = "+value );
        return value;
    }
    @Around("allMethod()")
    public Object countPeople(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("thoi gian truoc khi thay doi "+ LocalDateTime.now());
        Object value=null;
        try{
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("thoi gian xay ra loi: " + LocalDateTime.now());
            throwable.printStackTrace();
        }
        System.out.println("thoi gian sau khi thay doi" + LocalDateTime.now()+ "Return value = "+value );
        return value;
    }
}
