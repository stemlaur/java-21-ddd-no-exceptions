package fr.dalkia.fr.java21.common;

public record Error<OK, ERROR>(ERROR value) implements Result<OK, ERROR> {
}
