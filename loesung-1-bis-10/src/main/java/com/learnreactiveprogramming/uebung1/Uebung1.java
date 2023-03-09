package com.learnreactiveprogramming.uebung1;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung1 {

    // Übung 1
    //
    public Flux<String> superheldenFlux() {
        var namesList = List.of("alex", "malte", "melina", "tom");
        //return Flux.just("alex", "ben", "chloe");
        return Flux.fromIterable(namesList); // coming from a db or remote service

    }

    public Mono<String> superheldenMono() {

        return Mono.just("alex");

    }

    public static void main(String[] args) {

        Uebung1 uebung1 = new Uebung1();


    }

}