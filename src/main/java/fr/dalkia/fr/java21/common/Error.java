package fr.dalkia.fr.java21.common;

import java.util.Optional;

public record Error<OK, ERROR>(ERROR value) implements Result<OK, ERROR> {
    @Override
    public Optional<OK> toOptional() {
        return Optional.empty();
    }
}
