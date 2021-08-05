package com.reactivespring.controller;

import com.reactivespring.service.MoviesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest(controllers = FluxMonoController.class)
public class FluxMonoControllerUnitTest {

    // Übung 9
    //
    // 1 - Baue die folgenden Testmethoden.
    //

    // 2 - Binde den WebTestClient mit Hilfe  von dependency injection ein.


    @MockBean
    private MoviesInfoService moviesInfoServiceMock;

    @Test
    void flux() {

                // 3 - Nutze den Webtest
                // 3 - Führe einen get-request aus.
                // 4 - Füge den Endpunkt den du Ansprechen möchtest hinzu --> Tipp .uri(x).
                // 5 - .exchange() Performt den Austausch.
                // 6 - Ist der Responsestatus im 2xx Bereiech?
                // 7 - Das Flux enthält drei Elemente!
    }

    @Test
    void flux_approach2() {

        // 8 - Kopiere den Inhalt aus der flux() Testmethode und weise sie einer lokalen Variable flux zu.

        // 9 - Nutze Stepverifier.create(flux).

        //10 - Was erwartest du als Element?

        //11 - Hast du dran gedacht zu prüfen, ob onComplete() aufgerufen wurde?

    }

    @Test
    void stream() {

        // 12 - Füge den gleichen Inhalt bezogen auf den WebTestClient aus flux_approach2() ein. Kommentiere folgendes ein.
        // .returnResult(Integer.class)
        // .getResponseBody()

        // 13 - Auch hier kann der Stepverifier genutzt werden.

    }

}
