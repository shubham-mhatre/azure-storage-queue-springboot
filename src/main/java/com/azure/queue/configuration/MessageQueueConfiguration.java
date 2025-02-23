package com.azure.queue.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;

@Configuration
public class MessageQueueConfiguration {
	
	@Value("${spring.azure.storage.queue.endpoint}")
	private String azureStorageEndpoint;
	
	@Value("${spring.azure.shared.access.token}")
	private String azureSasToken;
	
	@Value("${spring.azure.storage.queue.name}")
	private String queueName;

	@Bean
	QueueClient getQueueClient() {
		QueueClient client =new QueueClientBuilder()
				.endpoint(azureStorageEndpoint)
				.queueName(queueName)
				.sasToken(azureSasToken)
				.buildClient();
		
		client.createIfNotExists();
		
		return client;
	}
}
