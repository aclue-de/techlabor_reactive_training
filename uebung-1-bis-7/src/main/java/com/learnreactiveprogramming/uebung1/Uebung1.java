package com.learnreactiveprogramming.uebung1;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung1 {

    // Übung 1
    //
    // 1 - Schreibe eine Methode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte zurück gibt. Jeder Name soll von Typ String sein.
    //
    // 2 - Gib einen Rückgabetyp an.
    //
    public Flux<String> superheldenFlux() {
        // 3 - Erzeuge eine Liste mit den Namen.

        // 4 - Gib das Flux mit den Namen der Superhelden zurück.
        return Flux.just("Alex", "Tom");

    }

    // 5 - Gib einen Rückgabetyp an.
    //
    public Mono<String> superheldenMono() {
        // 6 - Gib das Mono mit einem Namen eines Superhelden deiner Wahl zurück.
        return Mono.just("Alex");
    }

    // 7 - Start
    public static void main(String[] args) {

        Uebung1 uebung1 = new Uebung1();
        uebung1.superheldenFlux().log().subscribe(i -> System.out.println("Flux Element " + i));


    }

}
