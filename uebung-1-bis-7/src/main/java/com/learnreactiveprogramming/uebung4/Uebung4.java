package com.learnreactiveprogramming.uebung4;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung4 {

    // Übung 4
    //
    // 1 - Schreibe eine Methode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte in upper case zurück gibt. Zusätzlich dürfen
    //     jedoch ausschließlich Namen mit einer Zeichenlänge von 5 und größer zurück gegeben werden.
    //
    public Flux<String> superheldenFlux_map_filter() {
        return Flux.just("alex", "rapha", "melina", "malte")
                .map(String::toUpperCase);

        // 2 - Verwende einen Filter

        // 3 - Baue auch einen default ein, falls jeder Wert gefiltert wird.

        // 4 - Und weils so viel Spaß macht, gleich noch einen Test hinterher.

    }


    public Mono<String> superheldenMono_map_filter() {
        return Mono.just("alex")
                .map(String::toUpperCase);

        // 5 - Verwende einen Filter

        // 6 - Baue auch einen default ein, falls jeder Wert gefiltert wird.

    }

    // 7 - Start
    public static void main(String[] args) {

        Uebung4 uebung4 = new Uebung4();


    }

}
