package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping(path="producer/{message}")
	public String sendMessage(@PathVariable  String message) {
		producerService.produce(message);
		return "message is send";
	}
}
