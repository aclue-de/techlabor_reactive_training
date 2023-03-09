package com.learnreactiveprogramming.uebung6;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung6 {


    // Übung 6
    //
    public Flux<String> namesFlux_concatmap(int stringLength) {
        var namesList = List.of("alex", "ben", "chloe"); // a, l, e , x
        return Flux.fromIterable(namesList)
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                //.flatMap((name)-> splitString(name));
                .concatMap(this::splitString_withDelay);

    }

    private Flux<String> splitString_withDelay(String name) {
        var delay = new Random().nextInt(1000);
        var charArray = name.split("");
        return Flux.fromArray(charArray)
                .delayElements(Duration.ofMillis(delay));
    }

    // 4 - Start
    public static void main(String[] args) {

        Uebung6 uebung6 = new Uebung6();


    }

}
