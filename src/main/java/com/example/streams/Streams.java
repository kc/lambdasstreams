package com.example.streams;

import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.example.streams.ExampleCollections.persons;

public class Streams {

    public static void main(String[] args) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier: creert een muteerbare container voor de (tussen)resultaten
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator: voegt het volgende element toe aan de tot nu toe gevulde container en geeft de gevulde container terug
                        (j1, j2) -> j1.merge(j2),               // combiner: combineert twee containers die ontstaan bij parallel processing
                        j -> j.toString());                     // finisher: converteert de totaal gevulde container tot één waarde

        String collect = persons.stream().collect(personNameCollector);
        System.out.println(collect);
    }

}
