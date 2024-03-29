package fr.dalkia.fr.java21.withoutexceptions.domain;

import fr.dalkia.fr.java21.common.result.Error;
import fr.dalkia.fr.java21.common.result.Ok;
import fr.dalkia.fr.java21.withoutexceptions.domain.api.CreateProduct;
import fr.dalkia.fr.java21.withoutexceptions.domain.spi.Catalog;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;


public class ProductService implements CreateProduct {
    private final Catalog catalog;

    public ProductService(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public Optional<UUID> handle(String sku) {
        return switch (Product.create(sku)) {
            case Ok(var product) -> this.catalog.saveProduct(product).toOptional();
            case Error(var ignored) -> empty();
        };
    }
}
