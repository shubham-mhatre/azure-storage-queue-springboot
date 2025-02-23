package com.azure.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AzureStorageQueueSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureStorageQueueSpringbootApplication.class, args);
	}

}
