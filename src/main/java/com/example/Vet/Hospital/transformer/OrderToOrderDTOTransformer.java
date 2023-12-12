package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.OrderDTO;
import com.example.Vet.Hospital.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderToOrderDTOTransformer extends Transformer<OrderDTO, Order> {
    private final UserToUserDTOTransformer userToUserDTOTransformer;
    private final SubCategoryToSubCategoryDTOTransformer subCategoryToSubCategoryDTOTransformer;


    @Override
    public OrderDTO transform(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserDTO(userToUserDTOTransformer.transform(order.getUser()));
        orderDTO.setSubCategoryDTO(subCategoryToSubCategoryDTOTransformer.transform(order.getSubCategory()));
        orderDTO.setDateOfCreate(order.getDateOfCreate());
        orderDTO.setStatus(order.getStatus().name());
        return orderDTO;
    }
}
