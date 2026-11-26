package dev.abreuhenrique.ClothesStore.controller;

import dev.abreuhenrique.ClothesStore.dto.order.CreateOrderRequest;
import dev.abreuhenrique.ClothesStore.dto.order.OrderResponse;
import dev.abreuhenrique.ClothesStore.dto.order.UpdateOrderStatusRequest;
import dev.abreuhenrique.ClothesStore.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<OrderResponse> findByOrderNumber(@PathVariable Long orderNumber) {
        return ResponseEntity.ok(service.findByOrderNumber(orderNumber));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateOrderStatusRequest request
    ) {
        return ResponseEntity.ok(service.updateStatus(id, request));
    }
}
