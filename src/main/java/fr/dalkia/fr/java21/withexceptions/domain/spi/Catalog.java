package fr.dalkia.fr.java21.withexceptions.domain.spi;

import fr.dalkia.fr.java21.withexceptions.domain.CannotBeCreated;
import fr.dalkia.fr.java21.withexceptions.domain.Product;

public interface Catalog {
    // HERE WE USE CHECKED EXCEPTION
    void saveProduct(Product product) throws CannotBeCreated;
}
