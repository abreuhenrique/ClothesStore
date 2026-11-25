package dev.abreuhenrique.ClothesStore.mapper;

import dev.abreuhenrique.ClothesStore.dto.order.CreateOrderRequest;
import dev.abreuhenrique.ClothesStore.dto.order.OrderResponse;
import dev.abreuhenrique.ClothesStore.model.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper {

    private final AddressMapper addressMapper;
    private final OrderItemMapper orderItemMapper;

    public OrdersMapper(AddressMapper addressMapper, OrderItemMapper orderItemMapper) {
        this.addressMapper = addressMapper;
        this.orderItemMapper = orderItemMapper;
    }

    public Orders toEntity(CreateOrderRequest request) {
        Orders order = new Orders();
        order.setCustomerName(request.customerName());
        order.setCustomerEmail(request.customerEmail());
        order.setCustomerPhone(request.customerPhone());
        order.setShippingAddress(addressMapper.toEmbeddable(request.shippingAddress()));
        return order;
    }

    public OrderResponse toResponse(Orders order) {
        return new OrderResponse(
                order.getId(),
                order.getOrderNumber(),
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getCustomerPhone(),
                addressMapper.toResponse(order.getShippingAddress()),
                order.getOrderStatus(),
                order.getCreatedAt(),
                order.getSubtotal(),
                order.getShippingCost(),
                order.getTotal(),
                order.getItems().stream().map(orderItemMapper::toResponse).toList()
        );
    }
}
