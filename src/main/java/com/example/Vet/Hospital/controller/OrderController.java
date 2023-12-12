package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.dto.OrderDTO;
import com.example.Vet.Hospital.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO, @RequestHeader HttpHeaders httpHeaders){
        String token = httpHeaders.get("authorization").get(0).substring(7);
        OrderDTO save = orderService.addOrder(orderDTO, token);
        return ResponseEntity.ok(save);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders(@RequestHeader HttpHeaders httpHeaders){
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }



}
