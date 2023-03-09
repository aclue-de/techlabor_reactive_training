package com.reactivespring.controller.uebung89;

import reactor.core.publisher.Flux;

import java.time.Duration;

// Übung 8
//
// 1 - Baue einene RestController.
//

// 2 - Annotiere die Klasse.
public class FluxMonoController {



    // 3 - Erstelle für die Methode flux() ein GetMapping für den Endpunkt /flux.

    // 4 - Der Rückgabetyp ist ein Flux mit drei Integern 1, 2, 3 als Elementen.
    public void flux(){

        // 5 - Gib ein Flux mit drei Integern zurück.

    }

    // 6 - Erstelle für die Methode flux() ein GetMapping für den Endpunkt /mono.

    // 7 - Der Rückgabetyp ist ein Mono mit einem Element von Typ long.
    public void mono(){

        // 8 - Gib ein Mono mit dem Integer zurück.

    }

    // 9 - Erstelle für die Methode stream() ein GetMapping für den Endpunkt /stream.
    //     Vergiss dabei nicht produces = MediaType.TEXT_EVENT_STREAM_VALUE zum Mapping hinzuzufügen.

    public Flux<Long> stream(){
        return Flux.interval(Duration.ofSeconds(1))
                .log();
    }
}
