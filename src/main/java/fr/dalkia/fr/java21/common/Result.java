package fr.dalkia.fr.java21.common;

public sealed interface Result<OK, ERROR> permits Error, Ok {

    static <OK, ERROR> Result<OK, ERROR> ok(OK right) {
        return new Ok<>(right);
    }

    static <OK, ERROR> Result<OK, ERROR> error(ERROR left) {
        return new Error<>(left);
    }
}
