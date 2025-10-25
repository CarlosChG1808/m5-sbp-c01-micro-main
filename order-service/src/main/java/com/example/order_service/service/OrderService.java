package com.example.order_service.service;

import com.example.order_service.client.User;
import com.example.order_service.client.UserClient;
import com.example.order_service.dto.Order;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserClient  userClient;

    public Order getOrderById(Long id) {

        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);

        User user = userClient.getUserById(orderEntity.getUserId());
        log.info("User: {}", user.getName());

        return orderMapper.toDomainWithUser(orderEntity, user);
    }
}
