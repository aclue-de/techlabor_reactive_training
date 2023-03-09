package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;


public class FluxAndMonoGeneratorService {


    // Übung 1
    //
    // 1 - Schreibe eine Methode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte zurück gibt. Jeder Name soll von Typ String sein.
    //
    // 2 - Gib einen Rückgabetyp an.
    //
    public void superheldenFlux() {
        // 3 - Erzeuge eine Liste mit den Namen

        // 4 - Gib das Flux mit den Namen der Superhelden zurück.

    }

    // 5 - Gib einen Rückgabetyp an.
    //
    public void superheldenMono() {
        // 6 - Gib das Mono mit einem Namen eines Superhelden deiner Wahl zurück.

    }


    // Übung 3
    //
    // 1 - Schreibe eine Methode, welche ein Flux mit den Namen der Superhelden Alex,
    //     Rapha, Melina und Malte in upper case zurück gibt.
    //
    // 2 - Gib einen Rückgabetyp an.
    //
    public void superheldenFlux_map() {
        // 3 - Erzeuge eine Liste mit den Namen

        // 4 - Gib das Flux mit den Namen der Superhelden zurück
        //     und mache gebrauch von map(). Nutze Type::toUpperCase
        //     und ersetze Type mit dem Typen der Listenelemente

        // 5 - Gehe in die Testklasse und schreibe einen Test superheldenFlux_map.
    }

    public Flux<String> superhelden_immutablity() {
        var namesList = List.of("alex", "rapha", "melina", "malte");

        var namesFlux = Flux.fromIterable(namesList);
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }


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

                // 2 - Verwende einen Filter

                // 3 - Baue auch einen default ein, falls jeder Wert gefiltert wird.

    }


    // Übung 5
    //
    // Wende den flatMap() Operator an.
    //
    private void splitString(String name) {

        // 1 - Schreibe eine Methode, die einen String als
        //     Übergabeparameter hat und Diesen mit string.split(““) trennt.

        // 2 - Die Methode soll ein Flux vom Typ String zurück geben.
        //     Mit Flux.fromArray(charArray) wird ein jeder Eintrag des Arrays vom Flux gepubslihed.
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

    // 5 - Was wird als Reihenfolge der Elemente vom Flux angenommen?

    public Flux<String> superheldenFlux_flatmap_async(int stringLength) {
        var namesList = List.of("alex", "rapha", "melina", "malte");
        return Flux.fromIterable(namesList)
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitString_withDelay);

    }

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

                // 1 - Führe die Methode splitString_withDelay(x) mit dem concatMap() Operator aus.

                // 2 -  Vervollständige den Test für diese Methode.

    }

    // Übung 7
    //
    // 1 - Explore flatMap() mit Mono.
    //
    public Mono<List<String>> exploreMono_flatmap(int stringLength) {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitStringMono);
    }

    // 2 - splitStringMono(x) liefert als Rückgabe nun ein Mono mit Stringliste
    //     anstatt einem Flux mit Strings bei splitStringFlux().
    private Mono<List<String>> splitStringMono(String s) {
        var charArray = s.split("");
        return Mono.just(List.of(charArray))
                .delayElement(Duration.ofSeconds(1));
    }



    public Flux<String> exploreMono_flatmapMany(int stringLength) {
        return Mono.just("alex")
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .flatMapMany(this::splitString_withDelay);
    }


    public Flux<String> exploreFlux_transform(int stringLength) {

        Function<Flux<String>, Flux<String>> filterMap = name -> name.map(String::toUpperCase)
                .filter(s -> s.length() > stringLength);

        var namesList = List.of("alex", "ben", "chloe"); // a, l, e , x
        return Flux.fromIterable(namesList)
                .transform(filterMap) // gives u the opportunity to combine multiple operations using a single call.
                .defaultIfEmpty("default");
    }


    // "A", "B", "C", "D", "E", "F"
    public Flux<String> explore_concat() {

        var abcFlux = Flux.just("A", "B", "C");

        var defFlux = Flux.just("D", "E", "F");

        return Flux.concat(abcFlux, defFlux);

    }

    public Flux<String> explore_concatWith_mono() {

        var aMono = Mono.just("A");

        var bMono = Flux.just("B");

        return aMono.concatWith(bMono);

    }

    // "A", "D", "B", "E", "C", "F"
    public Flux<String> explore_merge() {

        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));

        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return Flux.merge(abcFlux, defFlux).log();

    }

    public Flux<String> explore_mergeWith_mono() {

        var aMono = Mono.just("A");

        var bMono = Flux.just("B", "C");

        return aMono.mergeWith(bMono);

    }

    // "A","B","C","D","E","F"
    public Flux<String> explore_mergeSequential() {

        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));

        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(150));

        return Flux.mergeSequential(abcFlux, defFlux).log();

    }

    // AD, BE, FC
    public Flux<String> explore_zip() {

        var abcFlux = Flux.just("A", "B", "C");

        var defFlux = Flux.just("D", "E", "F");

        return Flux.zip(abcFlux, defFlux, (first, second) -> first + second);


    }

    // AD14, BE25, CF36
    public Flux<String> explore_zip_1() {

        var abcFlux = Flux.just("A", "B", "C");
        var defFlux = Flux.just("D", "E", "F");
        var flux3 = Flux.just("1", "2", "3");
        var flux4 = Flux.just("4", "5", "6");

        return Flux.zip(abcFlux, defFlux, flux3, flux4)
                .map(t4 -> t4.getT1() + t4.getT2() + t4.getT3() + t4.getT4());

    }

    public Flux<String> explore_zip_2() {

        var aMono = Mono.just("A");
        var bMono = Mono.just("B");

        return Flux.zip(aMono, bMono, (first, second) -> first + second);


    }

    // AD, BE, CF
    public Flux<String> explore_zipWith() {

        var abcFlux = Flux.just("A", "B", "C");

        var defFlux = Flux.just("D", "E", "F");

        return abcFlux.zipWith(defFlux, (first, second) -> first + second);


    }

    public Mono<String> explore_zipWith_mono() {

        var aMono = Mono.just("A");

        var bMono = Mono.just("B");

        return aMono.zipWith(bMono)
                .map(t2 -> t2.getT1() + t2.getT2());

    }


    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        Flux<String> namesFlux = fluxAndMonoGeneratorService.splitString_withDelay("").log();

        namesFlux.subscribe((x) -> {
            System.out.println("Name is : " + x);
        });

        Flux<String> xxxFlux = fluxAndMonoGeneratorService.splitString_withDelay("").log();

        xxxFlux.subscribe(x -> System.out.println("Flux: " + x));

    }

}
