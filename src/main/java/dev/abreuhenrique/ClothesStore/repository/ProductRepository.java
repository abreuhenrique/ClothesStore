package dev.abreuhenrique.ClothesStore.repository;

import dev.abreuhenrique.ClothesStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
