package com.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.demo")
@EnableAspectJAutoProxy //spring + aspectJ
public class AppConfig {

}
