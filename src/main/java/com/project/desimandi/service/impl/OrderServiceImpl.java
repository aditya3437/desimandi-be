package com.project.desimandi.service.impl;

import com.project.desimandi.dto.OrderDTO;
import com.project.desimandi.entity.Order;
import com.project.desimandi.repository.OrderRepository;
import com.project.desimandi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> fetchAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> fetchOrdersByMobileNumber(String mobileNumber) {
        return orderRepository.findByUserMobileNumber(mobileNumber).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        order.setQuantity(order.getProducts().size());
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    // Convert Order to OrderDTO
    private OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .products(order.getProducts())
                .quantity(order.getQuantity())
                .userMobileNumber(order.getUserMobileNumber())
                .build();
    }

    // Convert OrderDTO to Order
    private Order convertToEntity(OrderDTO orderDTO) {
        return Order.builder()
                .orderId(UUID.randomUUID())
                .products(orderDTO.getProducts())
                .quantity(orderDTO.getQuantity())
                .userMobileNumber(orderDTO.getUserMobileNumber())
                .build();
    }
}
