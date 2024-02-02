package fr.dalkia.fr.java21.withexceptions.infra;

import fr.dalkia.fr.java21.withexceptions.domain.CannotBeCreated;
import fr.dalkia.fr.java21.withexceptions.domain.Product;
import fr.dalkia.fr.java21.withexceptions.domain.spi.Catalog;

import java.util.UUID;

public class CatalogOverHttp implements Catalog {
    @Override
    public UUID saveProduct(Product product) throws CannotBeCreated {
        try {
            // HERE we try to perform an operation that can fail
            return UUID.randomUUID();
        } catch (RuntimeException e) {
            // HERE WE USE A CHECKED EXCEPTION
            // BUT THE PROBLEM IS THE SAME WITH UNCHECKED EXCEPTIONS
            throw new CannotBeCreated();
        }
    }
}
