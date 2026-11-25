package dev.abreuhenrique.ClothesStore.dto.order;

import dev.abreuhenrique.ClothesStore.model.OrderStatus;

public record UpdateOrderStatusRequest(OrderStatus orderStatus) {
}
