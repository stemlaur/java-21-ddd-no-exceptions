package fr.dalkia.fr.java21.common.result;

import java.util.Optional;

public record Ok<OK, ERROR>(OK value) implements Result<OK, ERROR> {
    @Override
    public Optional<OK> toOptional() {
        return Optional.of(value);
    }
}
