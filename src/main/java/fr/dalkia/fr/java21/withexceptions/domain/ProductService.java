package fr.dalkia.fr.java21.withexceptions.domain;

import fr.dalkia.fr.java21.withexceptions.domain.api.CreateProduct;
import fr.dalkia.fr.java21.withexceptions.domain.spi.Catalog;

import java.util.Optional;
import java.util.UUID;

public class ProductService implements CreateProduct {
    private final Catalog catalog;

    public ProductService(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public Optional<UUID> handle(String sku) {
        try {
            UUID uuid = this.catalog.saveProduct(new Product(sku));
            return Optional.of(uuid);
        } catch (CannotBeCreated e) {
            return Optional.empty();
        }
    }
}
