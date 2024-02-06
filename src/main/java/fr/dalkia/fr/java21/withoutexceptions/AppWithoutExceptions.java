package fr.dalkia.fr.java21.withoutexceptions;

import fr.dalkia.fr.java21.withoutexceptions.domain.ProductService;
import fr.dalkia.fr.java21.withoutexceptions.domain.api.CreateProduct;
import fr.dalkia.fr.java21.withoutexceptions.infra.CatalogOverHttp;

public class AppWithoutExceptions {

    public static void main(String[] args) {
        CreateProduct createProduct = new ProductService(
                new CatalogOverHttp()
        );
        createProduct.handle("PP234134")
                .ifPresent(System.out::println);
    }
}
