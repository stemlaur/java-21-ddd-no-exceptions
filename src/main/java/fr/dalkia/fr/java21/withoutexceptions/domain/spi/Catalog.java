package fr.dalkia.fr.java21.withoutexceptions.domain.spi;

import fr.dalkia.fr.java21.common.Either;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;

import java.util.UUID;

public interface Catalog {
    Either<SaveProductResult, UUID> saveProduct(Product product);

    sealed interface SaveProductResult permits SaveProductResult.ConnectivityProblem {
        record ConnectivityProblem() implements SaveProductResult {}
    }
}
