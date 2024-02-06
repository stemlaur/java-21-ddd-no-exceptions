package fr.dalkia.fr.java21.common;

public record Ok<OK, ERROR>(OK value) implements Result<OK, ERROR> {
}
