package com.productapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 	<context:component-scan base-package="com.productapp"/>
	
 */

@Configuration //<context:annotation-config/>
@ComponentScan(basePackages = "com.productapp")
public class AppConfig {

}
