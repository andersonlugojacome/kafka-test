package com.digitalesweb.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
		return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                kafkaTemplate.send("DigitalesWeb-Topic", "Hello World DigitalesWeb, two, Send a new Message KAFKA");
            }
        };
	}


}
