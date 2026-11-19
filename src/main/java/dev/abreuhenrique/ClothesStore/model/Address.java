package dev.abreuhenrique.ClothesStore.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    private String cep;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;

}
