package dev.abreuhenrique.ClothesStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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

    @Column(unique = true, nullable = false)
    private String slug;
    private String name;
    private String description;
    private BigDecimal price;
    @Column(name = "img_url")
    private String imgUrl;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Category category;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Size> availableSizes;

}
