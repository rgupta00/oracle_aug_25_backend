package com.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//Aspect= advice + pointcut
public class AudianceAspect {
	
	//@After @AfterReturnging
	@AfterThrowing(value = "execution(public void doMagic())", 
			throwing =  "ex")
	public void clapping(Exception ex) {
		System.out.println(ex.getMessage());
	}
	
	
	
//	@Pointcut("execution(public void doMagic())")
//	public void foo() {}
//	
//	@After("foo()")
//	public void clapping() {
//		System.out.println("clapping...");
//	}
}
