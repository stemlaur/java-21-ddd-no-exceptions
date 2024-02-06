package fr.dalkia.fr.java21.withoutexceptions.domain;

sealed public interface SaveProductError permits SaveProductError.ConnectivityProblem {
    record ConnectivityProblem() implements SaveProductError {
    }
}
