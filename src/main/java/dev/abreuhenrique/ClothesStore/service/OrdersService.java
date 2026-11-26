package dev.abreuhenrique.ClothesStore.service;

import dev.abreuhenrique.ClothesStore.dto.order.CreateOrderRequest;
import dev.abreuhenrique.ClothesStore.dto.order.OrderItemRequest;
import dev.abreuhenrique.ClothesStore.dto.order.OrderResponse;
import dev.abreuhenrique.ClothesStore.dto.order.UpdateOrderStatusRequest;
import dev.abreuhenrique.ClothesStore.mapper.OrdersMapper;
import dev.abreuhenrique.ClothesStore.model.OrderItem;
import dev.abreuhenrique.ClothesStore.model.OrderStatus;
import dev.abreuhenrique.ClothesStore.model.Orders;
import dev.abreuhenrique.ClothesStore.model.Product;
import dev.abreuhenrique.ClothesStore.repository.OrdersRepository;
import dev.abreuhenrique.ClothesStore.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    private final OrdersMapper ordersMapper;

    public OrdersService(
            OrdersRepository ordersRepository,
            ProductRepository productRepository,
            OrdersMapper ordersMapper
    ) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
        this.ordersMapper = ordersMapper;
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> listAll() {
        return ordersRepository.findAll().stream()
                .map(ordersMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public OrderResponse findByOrderNumber(Long orderNumber) {
        return ordersMapper.toResponse(findEntityByOrderNumber(orderNumber));
    }

    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        validateCreateRequest(request);

        Orders order = ordersMapper.toEntity(request);
        order.setOrderNumber(nextOrderNumber());
        order.setOrderStatus(OrderStatus.CREATED);
        order.setShippingCost(BigDecimal.ZERO);

        BigDecimal subtotal = BigDecimal.ZERO;
        for (OrderItemRequest itemRequest : request.items()) {
            validateItemRequest(itemRequest);
            Product product = findProductById(itemRequest.productId());
            validateSelectedSize(product, itemRequest);

            BigDecimal itemSubtotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.quantity()));

            OrderItem item = new OrderItem();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setSelectedSize(itemRequest.selectedSize());
            item.setUnitPrice(product.getPrice());
            item.setQuantity(itemRequest.quantity());
            item.setSubtotal(itemSubtotal);
            order.addItem(item);

            subtotal = subtotal.add(itemSubtotal);
        }

        order.setSubtotal(subtotal);
        order.setTotal(subtotal.add(order.getShippingCost()));

        Orders savedOrder = ordersRepository.save(order);
        return ordersMapper.toResponse(savedOrder);
    }

    @Transactional
    public OrderResponse updateStatus(Long id, UpdateOrderStatusRequest request) {
        if (request == null || request.orderStatus() == null) {
            throw badRequest("Informe um status válido para o pedido.");
        }

        Orders order = findEntityById(id);
        order.setOrderStatus(request.orderStatus());

        Orders updatedOrder = ordersRepository.save(order);
        return ordersMapper.toResponse(updatedOrder);
    }

    private Orders findEntityById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Pedido com id " + id + " não encontrado."
                ));
    }

    private Orders findEntityByOrderNumber(Long orderNumber) {
        return ordersRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Pedido com número " + orderNumber + " não encontrado."
                ));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto com id " + id + " não encontrado."
                ));
    }

    private Long nextOrderNumber() {
        return ordersRepository.findTopByOrderByOrderNumberDesc()
                .map(order -> order.getOrderNumber() + 1)
                .orElse(1000L);
    }

    private void validateCreateRequest(CreateOrderRequest request) {
        if (request == null || request.items() == null || request.items().isEmpty()) {
            throw badRequest("O pedido deve possuir pelo menos um item.");
        }

        if (isBlank(request.customerName()) || isBlank(request.customerEmail()) || isBlank(request.customerPhone())) {
            throw badRequest("Informe nome, e-mail e telefone do cliente.");
        }

        if (request.shippingAddress() == null
                || isBlank(request.shippingAddress().cep())
                || isBlank(request.shippingAddress().street())
                || isBlank(request.shippingAddress().number())
                || isBlank(request.shippingAddress().district())
                || isBlank(request.shippingAddress().city())
                || isBlank(request.shippingAddress().state())) {
            throw badRequest("Informe todos os campos obrigatórios do endereço de entrega.");
        }
    }

    private void validateItemRequest(OrderItemRequest itemRequest) {
        if (itemRequest == null || itemRequest.productId() == null
                || itemRequest.selectedSize() == null || itemRequest.quantity() <= 0) {
            throw badRequest("Cada item deve ter produto, tamanho e quantidade positiva.");
        }
    }

    private void validateSelectedSize(Product product, OrderItemRequest itemRequest) {
        if (!product.getAvailableSizes().contains(itemRequest.selectedSize())) {
            throw badRequest("O tamanho selecionado não está disponível para o produto " + product.getId() + ".");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private ResponseStatusException badRequest(String message) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
}
