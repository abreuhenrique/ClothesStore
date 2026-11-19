package dev.abreuhenrique.ClothesStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", unique = true, nullable = false)
    private String orderNumber;
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    @Column(name = "customer_email", nullable = false)
    private String customerEmail;
    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

    @Embedded
    private Address shippingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private BigDecimal subtotal;
    @Column(name = "shipping_cost")
    private BigDecimal shippingCost;

    private BigDecimal total;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

}
