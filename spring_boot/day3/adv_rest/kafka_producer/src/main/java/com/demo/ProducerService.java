package com.demo;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void produce(String message) {
		log.info("messge is send to the kafka server-----------");
		kafkaTemplate.send("t-hello2", message);//fire and forget
		
	}
	
}
