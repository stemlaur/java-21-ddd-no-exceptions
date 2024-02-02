package fr.dalkia.fr.java21.withexceptions.domain.api;

import fr.dalkia.fr.java21.withexceptions.domain.Product;

public interface CreateProduct {

    boolean handle(String sku);
}
