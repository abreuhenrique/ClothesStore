package dev.abreuhenrique.ClothesStore.dto.order;

public record AddressResponse(
        String cep,
        String street,
        String number,
        String complement,
        String district,
        String city,
        String state
) {
}
