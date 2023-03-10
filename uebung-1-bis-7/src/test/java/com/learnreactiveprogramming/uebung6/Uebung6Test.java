package com.learnreactiveprogramming.uebung6;

import org.junit.jupiter.api.Test;

public class Uebung6Test {

    Uebung6 uebung6 = new Uebung6();


    // Übung 6
    //
    // 1 - Teste den concatMap() Operator.
    //
    @Test
    void namesFlux_concatMap() {

        //given
        int stringLength = 5;

        //when

        // 1.1 - Rufe mit uebung6 eine die zu testende Methode auf und weise sie einer Variable zu.

        //then
        //StepVerifier.create(namesFlux)
        //        .expectNextCount(5)
        //        .verifyComplete();

        // 2 - Erweitere die Kette um expectNext() und
        //     überlege welche Reihenfolge das Ergebnis hat.

        // 3 - Dauert die Ausführung von concatMap() oder flatMap() länger? Warum?

    }
}
