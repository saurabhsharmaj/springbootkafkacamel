package com.me.config;

import org.codehaus.jackson.map.ObjectMapper;

import com.me.model.Notification;

public class KafkaOutputBean {

	public void doWork(String body) {
		System.out.println("KafkaBody result >>>>> " + body);
	}
	
	public void consumeFirstTopic(String body) {
		System.out.println("First ->> KafkaBody result >>>>> " + body);
	}
	
	public void consumeSecondTopic(String body) {
		System.out.println("Second -> KafkaBody result >>>>> " + body);
	}

	public Notification retrieve(String body) {
		Notification message;
		try {
			message = new ObjectMapper().readValue(body, Notification.class);
		} catch (Exception e) {
			message = new Notification();
		}
		return message;
	}
}
