package com.logistics.works.kafka.event.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.logistics.works.kafka.event.UserCreatedEventDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEventProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	 @Value("${app.kafka.topic.user-created}")
	 private String topic;
	 
	public void publishUserCreatedEvent(UserCreatedEventDto event) {
		kafkaTemplate.send(topic, 
				event.getId().toString(),  // message key
				event);
	}
	
	/*
      Why key is important:
      same userId → same partition
      maintains ordering
      improves consumer performance
    */
}
