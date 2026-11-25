package dev.abreuhenrique.ClothesStore.repository;

import dev.abreuhenrique.ClothesStore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
