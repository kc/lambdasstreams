package com.example.streams.collect;

import com.example.streams.Person;

import java.util.StringJoiner;
import java.util.stream.Collector;

import static com.example.streams.ExampleCollections.persons;

public class CollectPerson {

    public String collectPersonNames() {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier: creert een muteerbare container voor de (tussen)resultaten
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator: voegt het volgende element toe aan de tot nu toe gevulde container en geeft de gevulde container terug
                        (j1, j2) -> j1.merge(j2),               // combiner: combineert twee containers; hier: voegt twee containers met strings samen met daartussen de delimiter
                        j -> j.toString());                     // finisher: converteert de totaal gevulde container tot één waarde

        return persons.stream().collect(personNameCollector);
    }
}
