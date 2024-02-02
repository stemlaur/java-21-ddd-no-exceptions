package fr.dalkia.fr.java21.common;

import java.util.NoSuchElementException;

/**
 * Either represents a value of two possible types. An Either is a {@link Left} or a {@link Right}.
 * <p>
 * @param <L> The type of the Left value of an Either.
 * @param <R> The type of the Right value of an Either.
 */
public sealed interface Either<L, R> {
    record Left<L, R>(L value) implements Either<L, R> {
        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public R get() {
            throw new NoSuchElementException("You try to access right but it is a left.");
        }

    }
    record Right<L, R>(R value) implements Either<L, R> {
        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public R get() {
            return value;
        }
    }

    boolean isRight();
    R get();
    default R orElse(R alternative) {
        return isRight() ? get() : alternative;
    }

    static <L, R> Either<L, R> right(R right) {
        return new Right<>(right);
    }
    static <L, R> Either<L, R> left(L left) {
        return new Left<>(left);
    }
}
