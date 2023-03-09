package com.learnreactiveprogramming.uebung4;

import org.junit.jupiter.api.Test;

public class Uebung4 {

    Uebung4 uebung4 = new Uebung4();


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
}
