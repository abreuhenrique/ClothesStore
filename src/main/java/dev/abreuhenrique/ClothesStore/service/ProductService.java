package dev.abreuhenrique.ClothesStore.service;

import dev.abreuhenrique.ClothesStore.dto.product.ProductRequest;
import dev.abreuhenrique.ClothesStore.dto.product.ProductResponse;
import dev.abreuhenrique.ClothesStore.mapper.ProductMapper;
import dev.abreuhenrique.ClothesStore.model.Product;
import dev.abreuhenrique.ClothesStore.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductResponse> listAll() {
        List<Product> list = repository.findAll();
        return list.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        return ProductMapper.toResponse(findEntityById(id));
    }

    public ProductResponse addProduct(ProductRequest req) {
        Product p = mapper.toEntity(req);
        repository.save(p);
        return ProductMapper.toResponse(p);
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product product = findEntityById(id);
        mapper.updateEntity(product, req);

        Product updatedProduct = repository.save(product);
        return ProductMapper.toResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = findEntityById(id);
        repository.delete(product);
    }

    private Product findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto com id " + id + " não encontrado."
                ));
    }
}
