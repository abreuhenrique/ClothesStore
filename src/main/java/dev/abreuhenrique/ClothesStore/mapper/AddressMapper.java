package dev.abreuhenrique.ClothesStore.mapper;

import dev.abreuhenrique.ClothesStore.dto.order.AddressRequest;
import dev.abreuhenrique.ClothesStore.dto.order.AddressResponse;
import dev.abreuhenrique.ClothesStore.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEmbeddable(AddressRequest request) {
        if (request == null) {
            return null;
        }

        return new Address(
                request.cep(),
                request.street(),
                request.number(),
                request.complement(),
                request.district(),
                request.city(),
                request.state()
        );
    }

    public AddressResponse toResponse(Address address) {
        if (address == null) {
            return null;
        }

        return new AddressResponse(
                address.getCep(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getDistrict(),
                address.getCity(),
                address.getState()
        );
    }
}
