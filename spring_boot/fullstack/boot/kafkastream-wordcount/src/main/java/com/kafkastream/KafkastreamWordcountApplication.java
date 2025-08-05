package com.kafkastream;

import java.util.Arrays;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
@EnableKafkaStreams
@SpringBootApplication
public class KafkastreamWordcountApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkastreamWordcountApplication.class, args);
	}
	 @Bean
	   Topology wordCountTopology(StreamsBuilder builder) {
	        builder.<String, String>stream("sentences")
	            .flatMapValues(value -> Arrays.asList(value.toLowerCase().split(" ")))
	            .groupBy((key, word) -> word)
	            .count(Materialized.with(Serdes.String(), Serdes.Long()))
	            .toStream()
	            .to("word-count", Produced.with(Serdes.String(), Serdes.Long()));

	        return builder.build();
	    }
}
