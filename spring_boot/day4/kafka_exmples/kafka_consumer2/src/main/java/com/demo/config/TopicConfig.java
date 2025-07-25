package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class TopicConfig {

	@Bean
	public NewTopic newTopic() {
		//public NewTopic(String name, int numPartitions, short replicationFactor)
		return new NewTopic("mynewtopic", 3, (short)1);
	}
	  @Bean
	    public Map<String, Object> consumerConfig() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
	                "localhost:9092");
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	                StringDeserializer.class);
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	                JsonDeserializer.class);
	        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
	        return props;
	    }

	    @Bean
	    public ConsumerFactory<String,Object> consumerFactory(){
	        return new DefaultKafkaConsumerFactory<>(consumerConfig());
	    }

	    @Bean
	    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>>
	        kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
