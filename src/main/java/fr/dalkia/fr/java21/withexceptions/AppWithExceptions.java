package fr.dalkia.fr.java21.withexceptions;

import fr.dalkia.fr.java21.withexceptions.domain.ProductService;
import fr.dalkia.fr.java21.withexceptions.domain.api.CreateProduct;
import fr.dalkia.fr.java21.withexceptions.infra.CatalogOverHttp;

public class AppWithExceptions {

    public static void main(String[] args) {
        CreateProduct createProduct = new ProductService(
                new CatalogOverHttp()
        );
        createProduct.handle("PP234134")
                .ifPresent(System.out::println);
    }
}
