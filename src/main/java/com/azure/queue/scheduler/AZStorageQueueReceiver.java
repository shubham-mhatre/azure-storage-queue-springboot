package com.azure.queue.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.models.QueueMessageItem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AZStorageQueueReceiver {
	
	private final QueueClient queueClient;
	
	@Scheduled(fixedRate = 5000)
	public void receiveMessages() {
		QueueMessageItem message= queueClient.receiveMessage();
		if(message!=null) {
			log.info("inside receiver scheduler :: start");
			String msgStr= message.getBody().toString();
			log.info("inside receiver scheduler :: received message : {}",msgStr);
			//to delete message from queue after receiving it
			//queueClient.deleteMessage(message.getMessageId(), message.getPopReceipt());
			log.info("inside receiver scheduler :: end");
		}
	}

}
