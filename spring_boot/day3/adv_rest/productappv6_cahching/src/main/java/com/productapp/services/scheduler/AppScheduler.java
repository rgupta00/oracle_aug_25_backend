package com.productapp.services.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.productapp.services.ProductService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AppScheduler {
	
	@Autowired
	private ProductService productService;
	
	@Scheduled(cron = "0/3 * * * * *")
	public void scheduleMethdod() {
		log.info("cache is invalidated...");
		productService.invalidate();
	}

}
