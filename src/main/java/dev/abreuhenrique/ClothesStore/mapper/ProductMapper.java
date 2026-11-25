package dev.abreuhenrique.ClothesStore.mapper;

import dev.abreuhenrique.ClothesStore.dto.product.ProductRequest;
import dev.abreuhenrique.ClothesStore.dto.product.ProductResponse;
import dev.abreuhenrique.ClothesStore.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        updateEntity(product, request);
        return product;
    }

    public void updateEntity(Product product, ProductRequest request) {
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setImgUrl(request.imgUrl());
        product.setCategory(request.category());
        product.setAvailableSizes(request.availableSizes() == null
                ? new HashSet<>()
                : new HashSet<>(request.availableSizes()));
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImgUrl(),
                product.getCategory(),
                new HashSet<>(product.getAvailableSizes())
        );
    }
}
