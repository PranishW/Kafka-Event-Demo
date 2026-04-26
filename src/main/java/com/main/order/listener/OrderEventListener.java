package com.main.order.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.order.controller.OrderController;
import com.main.order.model.Order;
import com.main.order.model.OrderEvent;
import com.main.order.repository.OrderRepository;

@Service
public class OrderEventListener {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderEventListener.class);
	@Autowired
	private OrderRepository orderRepository;
	
    @KafkaListener(topics = "new_orders",groupId = "HotelGroup")
    public void recieveOrder(OrderEvent event) {
    	logger.info(String.format("Received order: " + event));
        Order order = new Order();
        order.setFoodItem(event.getFoodItem());
        order.setQuantity(event.getQuantity());
        order = orderRepository.save(order);
        logger.info(String.format("Order placed successfully order Id :- "+order.getOrderId()));
    }
}
