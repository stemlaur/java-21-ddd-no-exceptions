package fr.dalkia.fr.java21.withoutexceptions.infra;

import fr.dalkia.fr.java21.common.Either;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;
import fr.dalkia.fr.java21.withoutexceptions.domain.spi.Catalog;

import java.util.UUID;

public class CatalogOverHttp implements Catalog {
    @Override
    public Either<SaveProductResult, UUID> saveProduct(Product product) {
        try {
            // HERE we try to perform an operation that can fail
            return Either.right(UUID.randomUUID());
        } catch (RuntimeException e) {
            // HERE WE USE A CHECKED EXCEPTION
            // BUT THE PROBLEM IS THE SAME WITH UNCHECKED EXCEPTIONS
            return Either.left(new SaveProductResult.ConnectivityProblem());
        }
    }
}
