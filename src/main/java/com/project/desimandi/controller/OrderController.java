package com.project.desimandi.controller;

import com.project.desimandi.dto.OrderDTO;
import com.project.desimandi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing orders in the Desimandi application.
 * Provides endpoints for fetching and placing orders.
 */
@RestController
@RequestMapping("/desimandi/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Fetches all orders in the system.
     *
     * @return ResponseEntity containing a list of OrderDTO objects representing all orders.
     */
    @GetMapping("/fetchAllOrders")
    public ResponseEntity<List<OrderDTO>> fetchAllOrders() {
        List<OrderDTO> orders = orderService.fetchAllOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Fetches orders associated with a specific mobile number.
     *
     * @param mobileNumber the mobile number to filter orders by.
     * @return ResponseEntity containing a list of OrderDTO objects associated with the given mobile number.
     */
    @GetMapping("/{mobileNumber}")
    public ResponseEntity<List<OrderDTO>> fetchOrdersByMobileNumber(@PathVariable String mobileNumber) {
        List<OrderDTO> orders = orderService.fetchOrdersByMobileNumber(mobileNumber);
        return ResponseEntity.ok(orders);
    }

    /**
     * Places a new order in the system.
     *
     * @param orderDTO the OrderDTO object containing order details to be saved.
     * @return ResponseEntity containing the saved OrderDTO object.
     */
    @PostMapping("/placeOrder")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrder = orderService.placeOrder(orderDTO);
        return ResponseEntity.ok(savedOrder);
    }
}
