package com.main.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic orderTopic()
	{
		System.out.println("Topic new_orders creation method");
		return new NewTopic("new_orders", 1,(short)1);
	}
}
