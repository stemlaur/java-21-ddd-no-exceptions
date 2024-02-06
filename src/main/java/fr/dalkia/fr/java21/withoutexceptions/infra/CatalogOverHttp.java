package fr.dalkia.fr.java21.withoutexceptions.infra;

import fr.dalkia.fr.java21.common.result.Result;
import fr.dalkia.fr.java21.withoutexceptions.domain.ConnectivityProblem;
import fr.dalkia.fr.java21.withoutexceptions.domain.Product;
import fr.dalkia.fr.java21.withoutexceptions.domain.SaveProductError;
import fr.dalkia.fr.java21.withoutexceptions.domain.UnknownError;
import fr.dalkia.fr.java21.withoutexceptions.domain.spi.Catalog;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

import static fr.dalkia.fr.java21.common.result.Result.error;
import static fr.dalkia.fr.java21.common.result.Result.ok;

public class CatalogOverHttp implements Catalog {
    @Override
    public Result<UUID, SaveProductError> saveProduct(Product product) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8000"))
                    .GET()
                    .build();
            String body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            return ok(UUID.fromString(body));
        } catch (IOException | InterruptedException e) {
            return error(new ConnectivityProblem());
        } catch (RuntimeException e) {
            return error(new UnknownError());
        }
    }
}
