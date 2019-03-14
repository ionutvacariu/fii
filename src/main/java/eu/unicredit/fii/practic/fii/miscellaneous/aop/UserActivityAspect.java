package eu.unicredit.fii.practic.fii.miscellaneous.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class UserActivityAspect {

    @Before("execution(* eu.unicredit.fii.practic.fii.controller.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        log.info("---AOP--- Check for user access ");
        log.info("---AOP--- Allowed execution for {}", joinPoint);
    }
}
