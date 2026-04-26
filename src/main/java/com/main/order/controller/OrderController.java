package com.main.order.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.order.model.OrderEvent;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	private final KafkaTemplate<String, OrderEvent> kafkatemplate;
	
	public OrderController(KafkaTemplate<String, OrderEvent> kafkatemplate)
	{
		this.kafkatemplate = kafkatemplate;
	}

	@PostMapping("/placeOrder")
	public @ResponseBody ResponseEntity<String> placeOrder(@RequestBody OrderEvent orderEvent)
	{
	    logger.info(String.format("Order initiated food Item :- "+orderEvent.getFoodItem()+" quantity :- "+orderEvent.getQuantity()));
		kafkatemplate.send("new_orders", orderEvent);
		return ResponseEntity.ok("Your order has been placed successfully");
	}
}
