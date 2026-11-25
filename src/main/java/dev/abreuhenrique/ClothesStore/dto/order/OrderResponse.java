package dev.abreuhenrique.ClothesStore.dto.order;

import dev.abreuhenrique.ClothesStore.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long orderNumber,
        String customerName,
        String customerEmail,
        String customerPhone,
        AddressResponse shippingAddress,
        OrderStatus orderStatus,
        LocalDateTime createdAt,
        BigDecimal subtotal,
        BigDecimal shippingCost,
        BigDecimal total,
        List<OrderItemResponse> items
) {
}
