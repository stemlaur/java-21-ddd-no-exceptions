package fr.dalkia.fr.java21.withoutexceptions.domain;

import fr.dalkia.fr.java21.common.Either;
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
            case Either.Left<InvalidSku, Product> ignored -> empty();
            case Either.Right<InvalidSku, Product>(var product) -> switch (this.catalog.saveProduct(product)) {
                case Either.Left<Catalog.SaveProductResult, UUID> ignored -> empty();
                case Either.Right<Catalog.SaveProductResult, UUID>(var productId) -> Optional.of(productId);
            };
        };
    }
}
