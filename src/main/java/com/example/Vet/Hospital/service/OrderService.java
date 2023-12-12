package com.example.Vet.Hospital.service;

import com.example.Vet.Hospital.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO, String token);
    List<OrderDTO> getAllOrders();
}
