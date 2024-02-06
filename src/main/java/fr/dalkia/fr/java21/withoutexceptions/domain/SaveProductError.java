package fr.dalkia.fr.java21.withoutexceptions.domain;

sealed public interface SaveProductError permits ConnectivityProblem, UnknownError {
}
