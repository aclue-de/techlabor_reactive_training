package com.learnreactiveprogramming.uebung4;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung4 {

    // Übung 4
    //
    // 1 - Schreibe eine Methode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte in upper case zurück gibt. Zusätzlich dürfen
    //     jedoch ausschließlich Namen mit einer Zeichenlänge von 5 und größer zurück gegeben werden.
    //
    public Flux<String> superheldenFlux_flatmap(int stringLength) {
        var namesList = List.of("alex", "rapha", "alex");
        return Flux.fromIterable(namesList)
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength);
    }


    public Mono<String> superheldenMono_map_filter(int stringLength) {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                .defaultIfEmpty("default");

    }

    // 7 - Start
    public static void main(String[] args) {

        Uebung4 uebung4 = new Uebung4();


    }

}


