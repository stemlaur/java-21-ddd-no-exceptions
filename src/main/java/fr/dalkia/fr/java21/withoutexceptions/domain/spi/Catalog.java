package fr.dalkia.fr.java21.withoutexceptions.domain.spi;

import fr.dalkia.fr.java21.common.result.Result;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;
import fr.dalkia.fr.java21.withoutexceptions.domain.SaveProductError;

import java.util.UUID;

public interface Catalog {
    Result<UUID, SaveProductError> saveProduct(Product product);

}
