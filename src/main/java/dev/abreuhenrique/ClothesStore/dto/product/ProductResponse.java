package dev.abreuhenrique.ClothesStore.dto.product;

import dev.abreuhenrique.ClothesStore.model.Category;
import dev.abreuhenrique.ClothesStore.model.Size;

import java.math.BigDecimal;
import java.util.Set;

public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String imgUrl,
        Category category,
        Set<Size> availableSizes
) {
}
