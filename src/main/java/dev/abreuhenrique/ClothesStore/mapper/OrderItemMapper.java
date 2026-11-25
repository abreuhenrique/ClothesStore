package dev.abreuhenrique.ClothesStore.mapper;

import dev.abreuhenrique.ClothesStore.dto.order.OrderItemResponse;
import dev.abreuhenrique.ClothesStore.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResponse toResponse(OrderItem item) {
        return new OrderItemResponse(
                item.getProductId(),
                item.getProductName(),
                item.getSelectedSize(),
                item.getUnitPrice(),
                item.getQuantity(),
                item.getSubtotal()
        );
    }
}
