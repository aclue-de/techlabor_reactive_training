package com.learnreactiveprogramming.uebung6;

import java.util.List;
import reactor.core.publisher.Flux;

public class Uebung6 {


    // Übung 6
    //
    // 1 - Wende den concatMap() Operator an. Erweitere die Methode um
    //     concatMap() und führe auf jedem Namen die Methode splitString_withDelay(x) aus.
    //
    public Flux<String> superheldenFlux_concatmap(int stringLength) {
        var namesList = List.of("alex", "rapha", "melina", "malte");
        return Flux.fromIterable(namesList)
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength);

        // 2 - Führe die Methode splitString_withDelay(x) mit dem concatMap() Operator aus.

        // 3 -  Vervollständige den Test für diese Methode.

    }

    // 4 - Start
    public static void main(String[] args) {

        Uebung6 uebung6 = new Uebung6();


    }

}
