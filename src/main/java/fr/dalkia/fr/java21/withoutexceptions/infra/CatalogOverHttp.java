package fr.dalkia.fr.java21.withoutexceptions.infra;

import fr.dalkia.fr.java21.common.Result;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;
import fr.dalkia.fr.java21.withoutexceptions.domain.spi.Catalog;
import fr.dalkia.fr.java21.withoutexceptions.domain.SaveProductError;

import java.util.UUID;

public class CatalogOverHttp implements Catalog {
    @Override
    public Result<UUID, SaveProductError> saveProduct(Product product) {
        try {
            // HERE we try to perform an operation that can fail
            return Result.ok(UUID.randomUUID());
        } catch (RuntimeException e) {
            // HERE WE USE A CHECKED EXCEPTION
            // BUT THE PROBLEM IS THE SAME WITH UNCHECKED EXCEPTIONS
            return Result.error(new SaveProductError.ConnectivityProblem());
        }
    }
}
