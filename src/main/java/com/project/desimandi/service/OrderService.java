package com.project.desimandi.service;

import com.project.desimandi.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderDTO> fetchAllOrders();
    List<OrderDTO> fetchOrdersByMobileNumber(String mobileNumber);
    OrderDTO placeOrder(OrderDTO orderDTO);
}
