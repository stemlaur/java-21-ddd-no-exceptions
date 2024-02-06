package fr.dalkia.fr.java21.withoutexceptions.infra;

import fr.dalkia.fr.java21.common.result.Result;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;
import fr.dalkia.fr.java21.withoutexceptions.domain.spi.Catalog;
import fr.dalkia.fr.java21.withoutexceptions.domain.SaveProductError;

import java.util.UUID;

import static fr.dalkia.fr.java21.common.result.Result.error;
import static fr.dalkia.fr.java21.common.result.Result.ok;

public class CatalogOverHttp implements Catalog {
    @Override
    public Result<UUID, SaveProductError> saveProduct(Product product) {
        try {
            return ok(UUID.randomUUID());
        } catch (RuntimeException e) {
            return error(new SaveProductError.ConnectivityProblem());
        }
    }
}
