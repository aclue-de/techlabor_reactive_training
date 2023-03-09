package com.learnreactiveprogramming.uebung5;

import org.junit.jupiter.api.Test;

public class Uebung5 {

    Uebung5 uebung5 = new Uebung5();


    // Übung 5
    //
    // 1 - flatMap()
    //
    @Test
    void superheldenFlux_flatmap() {

        //given
        int stringLength = 4;

        //when

        // 1.1 - Rufe mit uebung5 eine die zu testende Methode auf und weise sie einer Variable zu.

        //then

        // 1.2 - Stimmt das Ergebnis?
        //StepVerifier.create(superheldenFlux)
        //        .expectNext("R", "A", "P", "H", "A", "M", "E", "L", "I", "N", "A", "M", "A", "L", "T", "E")
        //        .verifyComplete();

    }

    // 2 - Asynchronität von flatMap()
    @Test
    void superheldenFlux_flatmap_async() {

        //given
        int stringLength = 5;

        //when

        // 2.1 - Rufe mit uebung5 eine die zu testende Methode auf und weise sie einer Variable zu.

        //then
        //StepVerifier.create(superheldenFlux)
        //        .expectNext("M", "E", "L", "I", "N", "A")
        //        .expectNextCount(6)
        //        .verifyComplete();

    }

}
