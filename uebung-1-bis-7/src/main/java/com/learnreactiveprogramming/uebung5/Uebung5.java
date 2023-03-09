package com.learnreactiveprogramming.uebung5;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;

public class Uebung5 {


    // Übung 5
    //
    // Wende den flatMap() Operator an.
    //
    private void splitString(String name) {

        // 1 - Schreibe eine Methode, die einen String als
        //     Übergabeparameter hat und Diesen mit string.split(““) trennt.

        // 2 - Die Methode soll ein Flux vom Typ String zurück geben.
        //     Flux.fromArray(charArray)
        //     Das bedeutet: Array("BERT") -> Flux("B", "E", "R", "T")
    }

    public Flux<String> superheldenFlux_flatmap(int stringLength) {
        var namesList = List.of("alex", "rapha", "melina", "malte");
        return Flux.fromIterable(namesList)
                .map(String::toUpperCase) // oder .map(s -> s.toUpperCase())
                .filter(s -> s.length() > stringLength);

        // 3 - Verwende .flatMap() und wende auf jedem Eintrag splitString(name) an.

        // Wie wird das Ergebnis aussehen? ALEX,RAPHA -> A, L, E, X, R, A, P, H, A

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
