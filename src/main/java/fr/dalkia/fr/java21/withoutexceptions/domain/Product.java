package fr.dalkia.fr.java21.withoutexceptions.domain;

import fr.dalkia.fr.java21.common.result.Result;

public final class Product {
    private final String sku;

    private Product(String sku) {
        this.sku = sku;
    }

    public static Result<Product, InvalidSku> create(String sku) {
        if (validateSku(sku)) {
            return Result.ok(new Product(sku));
        } else {
            return Result.error(new InvalidSku());
        }
    }

    private static boolean validateSku(String sku) {
        return sku != null && !sku.trim().isEmpty();
    }

    public String sku() {
        return sku;
    }
}
