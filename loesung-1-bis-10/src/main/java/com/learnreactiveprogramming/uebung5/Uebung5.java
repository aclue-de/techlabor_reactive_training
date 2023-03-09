package com.learnreactiveprogramming.uebung5;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Uebung5 {


    // Übung 5
    //
    // Wende den flatMap() Operator an.
    //
    private Flux<String> splitString(String name) {
        var charArray = name.split("");
        return Flux.fromArray(charArray);
    }

    public Flux<String> superheldenFlux_flatmap(int stringLength) {
        var namesList = List.of("alex", "franz", "heidi"); // a, l, e , x
        return Flux.fromIterable(namesList)
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitString).log();


    }

    // 4 - Async von flatMap()

    private Flux<String> splitString_withDelay(String name) {
        var delay = new Random().nextInt(1000);
        var charArray = name.split("");
        return Flux.fromArray(charArray)
                .delayElements(Duration.ofMillis(delay));
    }

    // 5 - Was wird als Reihenfolge der Elemente bei (stringLength = 5) vom Flux angenommen?

    public Flux<String> superheldenFlux_flatmap_async(int stringLength) {
        var namesList = List.of("alex", "rapha", "melina", "malte");
        return Flux.fromIterable(namesList)
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitString_withDelay);

    }

    // 6 - Start
    public static void main(String[] args) {

        Uebung5 uebung5 = new Uebung5();


    }

}
