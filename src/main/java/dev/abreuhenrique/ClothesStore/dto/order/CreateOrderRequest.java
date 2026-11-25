package dev.abreuhenrique.ClothesStore.dto.order;

import java.util.List;

public record CreateOrderRequest(
        String customerName,
        String customerEmail,
        String customerPhone,
        AddressRequest shippingAddress,
        List<OrderItemRequest> items
) {
}
