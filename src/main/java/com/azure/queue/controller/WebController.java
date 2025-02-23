package com.azure.queue.controller;

import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.models.SendMessageResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * controller to send message to azure storage queue.
 * we also have created scheduler to receive message. 
 * we can have other spring boot application to receive message as well, 
 * but for demo we have scheduler to receive message in same service only inside scheduler package.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebController {
	
	private final QueueClient queueClient;
	
	@GetMapping("/message/{message}")
	public String sendMessage(@PathVariable("message") String message) {
		
		log.info("inside controller :: start");
		
		if(null!=message && message.trim() !=null) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("message", message);
			jsonObject.put("userId", 2);
			jsonObject.put("requestTimeStamp", LocalDateTime.now());
			SendMessageResult result= queueClient.sendMessage(jsonObject.toString());
			System.out.println("message id "+result.getMessageId());
			log.info("message id : {} ",result.getMessageId());
			return "message sent successfully :: message id : "+result.getMessageId();
		}
		
		log.info("inside controller :: end");
		return "message is empty";
	}

}
