package dev.abreuhenrique.ClothesStore.repository;

import dev.abreuhenrique.ClothesStore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByOrderNumber(Long orderNumber);

    Optional<Orders> findTopByOrderByOrderNumberDesc();
}
