package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;
import java.util.List;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    // Übung 2
    //
    // 1 - Schreibe eine Testmethode, welche prüft, ob das Flux die Namen der Superhelden Alex,
    //     Rapha, Melina und Malte zurück gibt.
    //
    @Test
    void superheldenFlux() {

        //given

        //when

        // 3 - Rufe die Methode mit deinem Service auf (siehe oben).

        //then

        // 4 - Nutze den Step Verifier um das Flux zu testen.

    }

    // 5 - Benenne die Methode.
    @Test
    void superheldenMono() {

        //given

        //when

        // 6 - Rufe die Methode mit deinem Service auf.

        //then

        // 7 - Nutze den Step Verifier um das Flux zu testen.

    }

    // Übung 3
    //
    // 1 - Schreibe eine Testmethode, welche prüft, ob das Flux die Namen der Superhelden Alex,
    //     Rapha, Melina und Malte in Großbuchstaben zurück gibt.
    //
    @Test
    void superheldenFlux_map() {
        //given

        //when

        // 2 - Rufe die Methode mit deinem Service auf.

        //then

        // 3 - Nutze den Step Verifier um das Flux zu testen.

    }

    // immutability
    //
    // 1 - Flux und Mono sind immutable.
    //
    @Test
    void namesFlux_immutability() {

        //given

        //when
        var stringFlux = fluxAndMonoGeneratorService.superhelden_immutablity()
                .log();

        //then
        StepVerifier.create(stringFlux)
                //.expectNext("ALEX", "RAPHA", "MELINA", "MALTE")
                .expectNextCount(4)
                .verifyComplete();

    }


    // Übung 4
    //
    // 1 - Schreibe eine TestMethode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte in upper case prüft. Zusätzlich dürfen
    //     jedoch ausschließlich Namen mit einer Zeichenlänge von 5 und größer im Flux beinhaltet sein.
    //
    @Test
    void superheldenFlux_map_filter() {

        //given

        // 2 - Gib die Zeichenlänge an.

        //when

        // 3 - Rufe die Methode mit deinem Service auf.

        //then

        // 4 - Nutze den Step Verifier um das Flux zu testen.

    }

    @Test
    void superheldenFlux_map_empty() {

        //given

        int stringLength = 4;

        //when

        // 5 - Rufe die Methode mit deinem Service auf.

        //then

        // 6 - Nutze den Step Verifier um das Flux zu testen.
        //     Was wird als Rückgabe erwartet, wenn jedes Element der Menge ausgefiltert wird?

    }


    // Übung 5
    //
    // 1 - flatMap()
    //
    @Test
    void superheldenFlux_flatmap() {

        //given
        int stringLength = 4;

        //when
        var superheldenFlux = fluxAndMonoGeneratorService.superheldenFlux_flatmap(stringLength).log();

        //then
        StepVerifier.create(superheldenFlux)
                .expectNext("R", "A", "P", "H", "A", "M", "E", "L", "I", "N", "A", "M", "A", "L", "T", "E")
                .verifyComplete();

    }

    // 2 - Asynchronität von flatMap()
    @Test
    void superheldenFlux_flatmap_async() {

        //given
        int stringLength = 5;

        //when
        var superheldenFlux = fluxAndMonoGeneratorService.superheldenFlux_flatmap_async(stringLength).log();

        //then
        StepVerifier.create(superheldenFlux)
                .expectNext("M", "E", "L", "I", "N", "A")
                .expectNextCount(6)
                .verifyComplete();

    }

    // Übung 6
    //
    // 1 - Teste den concatMap() Operator.
    //
    @Test
    void namesFlux_concatMap() {

        //given
        int stringLength = 5;

        //when
        var namesFlux = fluxAndMonoGeneratorService.superheldenFlux_concatmap(stringLength).log();

        //then
        StepVerifier.create(namesFlux)
                .expectNextCount(5)
                .verifyComplete();
        // 2 - Erweitere die Kette um expectNext() und
        //     überlege welche Reihenfolge das Ergebnis hat.

        // 3 - Dauert die Ausführung von concatMap() oder flatMap() länger? Warum?

    }

    // Übung 7
    //
    // 1 - Explore faltMap() auf Mono.
    //
    @Test
    void exploreMono_flatmap() {

        //given
        int stringLength = 3;

        //when
        var exploreMono = fluxAndMonoGeneratorService.exploreMono_flatmap(stringLength).log();

        //then

        // 2 - Was wird als Ergebnis erwartet?

        StepVerifier.create(exploreMono)
                .verifyComplete();

        // 3 - Verkette ein expectNext(deineErwartung), sodas der Test successful ist.

    }

    @Test
    void namesMono_flatmapMany() {

        //given
        int stringLength = 3;

        //when
        var namesFlux = fluxAndMonoGeneratorService.exploreMono_flatmapMany(stringLength).log();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X")
                .verifyComplete();

    }


    @Test
    void namesFlux_transform() {

        //given
        int stringLength = 3;

        //when
        var namesFlux = fluxAndMonoGeneratorService.exploreFlux_transform(stringLength).log();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X")
                .expectNextCount(5)
                .verifyComplete();

    }

    @Test
    void namesFlux_transform_1() {

        //given
        int stringLength = 6;

        //when
        var namesFlux = fluxAndMonoGeneratorService.exploreFlux_transform(stringLength).log();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("default")
                //.expectNextCount(5)
                .verifyComplete();

    }

    @Test
    void explore_concat() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_concat();

        //then
        StepVerifier.create(value)
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    void explore_concat_mono() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_concatWith_mono();

        //then
        StepVerifier.create(value)
                .expectNext("A", "B")
                .verifyComplete();

    }

    @Test
    void explore_merge() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_merge();

        //then
        StepVerifier.create(value)
                // .expectNext("A", "B", "C", "D", "E", "F")
                .expectNext("A", "D", "B", "E", "C", "F")
                .verifyComplete();

    }

    @Test
    void explore_mergeWith_mono() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_mergeWith_mono();

        //then
        StepVerifier.create(value)

                .expectNext("A", "B", "C")
                .verifyComplete();

    }

    @Test
    void explore_mergeSequential() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_mergeSequential();

        //then
        StepVerifier.create(value)
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    void explore_zip() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_zip().log();

        //then
        StepVerifier.create(value)
                .expectNext("AD", "BE", "CF")
                .verifyComplete();

    }

    @Test
    void explore_zip_1() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_zip_1().log();

        //then
        StepVerifier.create(value)
                .expectNext("AD14", "BE25", "CF36")
                .verifyComplete();

    }


    @Test
    void explore_zip_2() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_zip_2().log();

        //then
        StepVerifier.create(value)
                .expectNext("AB")
                .verifyComplete();

    }

    @Test
    void explore_zipWith() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_zipWith().log();

        //then
        StepVerifier.create(value)
                .expectNext("AD", "BE", "CF")
                .verifyComplete();

    }

    @Test
    void explore_zipWith_mono() {

        //given

        //when
        var value = fluxAndMonoGeneratorService.explore_zipWith_mono().log();

        //then
        StepVerifier.create(value)
                .expectNext("AB")
                .verifyComplete();

    }

}