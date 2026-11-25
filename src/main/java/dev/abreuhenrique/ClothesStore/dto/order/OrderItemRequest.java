package dev.abreuhenrique.ClothesStore.dto.order;

import dev.abreuhenrique.ClothesStore.model.Size;

public record OrderItemRequest(
        Long productId,
        Size selectedSize,
        int quantity
) {
}
