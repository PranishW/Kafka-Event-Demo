package com.main.order.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.order.model.Order;
import com.main.order.model.OrderEvent;
import com.main.order.repository.OrderRepository;

@Service
public class OrderEventListener {
	
	@Autowired
	private OrderRepository orderRepository;
	
    @KafkaListener(topics = "new_orders")
    public void consume(OrderEvent event) {
    	System.out.println("Received order: " + event);
        Order order = new Order();
        order.setFoodItem(event.getFoodItem());
        order.setQuantity(event.getQuantity());
        order = orderRepository.save(order);
        System.out.println("Order placed successfully order Id :- "+order.getOrderId());
    }
}
