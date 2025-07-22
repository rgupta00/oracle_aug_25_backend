package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bankapp.dto.DataDto;
@EnableConfigurationProperties(DataDto.class)
@SpringBootApplication
public class BankappPropdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappPropdemoApplication.class, args);
	}

}
