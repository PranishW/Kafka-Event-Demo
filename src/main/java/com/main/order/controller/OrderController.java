package com.main.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.order.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@PostMapping("/placeOrder")
	public @ResponseBody ResponseEntity<String> placeOrder(@RequestBody Order order)
	{
		return ResponseEntity.ok("Your order has been placed successfully");
	}
}
