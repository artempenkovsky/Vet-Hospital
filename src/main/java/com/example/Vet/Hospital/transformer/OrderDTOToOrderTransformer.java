package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.OrderDTO;
import com.example.Vet.Hospital.model.Order;
import com.example.Vet.Hospital.model.OrderStatus;
import com.example.Vet.Hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderDTOToOrderTransformer extends Transformer<Order, OrderDTO>{
    private final SubCategoryDtoToSubCategoryTransformer subCategoryTransformer;
    private final UserRepository userRepository;
    @Override
    public Order transform(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        //order.setUser(userRepository.findById(orderDTO.getUserDTO().getId()).orElse(null));
        order.setSubCategory(subCategoryTransformer.transform(orderDTO.getSubCategoryDTO()));
        OrderStatus orderStatus = OrderStatus.valueOf(orderDTO.getStatus());
        order.setStatus(orderStatus);
        return order;
    }
}
