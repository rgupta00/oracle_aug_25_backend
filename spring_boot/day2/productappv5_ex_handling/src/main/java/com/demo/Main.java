package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	//AspectJ: AOP
	public static void main(String[] args) {
		ApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Magician magician=(Magician) ctx.getBean("m");
		System.out.println(magician.getClass());
		
		Magician magician2=new Magician();
		System.out.println(magician2.getClass());
		magician.doMagic();
		
	}
}
