package com.example.streams.collect;

import com.example.streams.Person;

import java.util.StringJoiner;
import java.util.stream.Collector;

import static com.example.streams.ExampleCollections.persons;

/**
 * Demo of:
 * - Collectors, through a custom Collector
 * - collect vs reduce.
 */
public class CollectPerson {

    public String collectPersonNames() {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier: creert een muteerbare container voor de (tussen)resultaten
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator: voegt het volgende element toe aan de tot nu toe gevulde container en geeft de gevulde container terug
                        (j1, j2) -> j1.merge(j2),               // combiner: combineert twee containers die ontstaan bij parallel processing
                        j -> j.toString());                     // finisher: converteert de totaal gevulde container tot één waarde

        return persons.stream().collect(personNameCollector);
    }

    public String reducePersonNames() {
        return persons.stream()
                .map(p -> p.name)
                .map(String::toUpperCase)
                .reduce((s1, s2) -> s1 + " | " + s2)
                .orElse("")
                ;
    }
}
