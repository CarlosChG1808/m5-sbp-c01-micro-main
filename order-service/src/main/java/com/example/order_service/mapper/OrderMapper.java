package com.example.order_service.mapper;


import com.example.order_service.client.User;
import com.example.order_service.dto.Order;
import com.example.order_service.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

    default Order toDomainWithUser(OrderEntity orderEntity, User user) {
        Order order = toDomain(orderEntity);
        order.setCreatedbyUser(user);
        return order;
    }
}
