package fr.dalkia.fr.java21.withexceptions.domain.api;

import java.util.Optional;
import java.util.UUID;

public interface CreateProduct {

    Optional<UUID> handle(String sku);
}
