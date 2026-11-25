package dev.abreuhenrique.ClothesStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String name;
    private String description;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "img_url", length = 255)
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Category category;

    @ElementCollection
    @CollectionTable(
            name = "product_available_sizes",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "size", nullable = false, length = 2)
    private Set<Size> availableSizes = new HashSet<>();

}
