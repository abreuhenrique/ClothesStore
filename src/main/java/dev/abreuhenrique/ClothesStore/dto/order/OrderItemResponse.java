package dev.abreuhenrique.ClothesStore.dto.order;

import dev.abreuhenrique.ClothesStore.model.Size;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long productId,
        String productName,
        Size selectedSize,
        BigDecimal unitPrice,
        int quantity,
        BigDecimal subtotal
) {
}
