package fr.dalkia.fr.java21.withoutexceptions.domain;

import fr.dalkia.fr.java21.common.Either;

public final class Product {
    private final String sku;

    private Product(String sku) {
        this.sku = sku;
    }

    public static Either<InvalidSku, Product> create(String sku) {
        if (validateSku(sku)) {
            return Either.left(new InvalidSku());
        } else {
            return Either.right(new Product(sku));
        }
    }

    private static boolean validateSku(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String sku() {
        return sku;
    }
}
