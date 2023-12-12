package com.example.Vet.Hospital.service.impl;

import com.example.Vet.Hospital.dto.OrderDTO;
import com.example.Vet.Hospital.model.Order;
import com.example.Vet.Hospital.repository.OrderRepository;
import com.example.Vet.Hospital.repository.UserRepository;
import com.example.Vet.Hospital.service.JwtService;
import com.example.Vet.Hospital.service.OrderService;
import com.example.Vet.Hospital.transformer.OrderDTOToOrderTransformer;
import com.example.Vet.Hospital.transformer.OrderToOrderDTOTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDTOToOrderTransformer orderDTOToOrderTransformer;
    private final OrderToOrderDTOTransformer orderToOrderDTOTransformer;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO, String token) {
        String login = jwtService.getUserName(token);

        Order order = orderDTOToOrderTransformer.transform(orderDTO);
        order.setDateOfCreate(LocalDate.now());
        order.setUser(userRepository.findByLogin(login).orElse(null));
        Order save = orderRepository.save(order);
        System.out.println();
        return orderToOrderDTOTransformer.transform(save);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderRepository.findAllByUserLogin(login);
        return orderRepository
                .findAllByUserLogin(login)
                .stream()
                .map(orderToOrderDTOTransformer::transform)
                .collect(Collectors.toList());
    }
}
