package fr.dalkia.fr.java21.withexceptions.domain;

import fr.dalkia.fr.java21.withexceptions.domain.api.CreateProduct;
import fr.dalkia.fr.java21.withexceptions.domain.spi.Catalog;

public class ProductService implements CreateProduct {
    private final Catalog catalog;

    public ProductService(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean handle(String sku) {
        try {
            this.catalog.saveProduct(new Product(sku));
            return true;
        } catch (CannotBeCreated e) {
            return false;
        }
    }
}
