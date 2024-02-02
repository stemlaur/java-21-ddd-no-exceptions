package fr.dalkia.fr.java21.withexceptions.domain.spi;

import fr.dalkia.fr.java21.withexceptions.domain.CannotBeCreated;
import fr.dalkia.fr.java21.withexceptions.domain.Product;

import java.util.UUID;

public interface Catalog {
    // HERE WE USE CHECKED EXCEPTION
    UUID saveProduct(Product product) throws CannotBeCreated;
}
