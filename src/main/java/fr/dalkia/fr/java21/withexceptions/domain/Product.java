package fr.dalkia.fr.java21.withexceptions.domain;

public record Product(String sku) {
    public Product(String sku) {
        this.sku = validateSku(sku);
    }

    private String validateSku(String sku) {
        // HERE WE USE UNCHECKED EXCEPTION
        if (sku == null || sku.trim().isEmpty()) {
            throw new InvalidSku();
        }
        return sku;
    }
}
