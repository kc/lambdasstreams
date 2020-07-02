package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingSupplier.concat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsingSupplierTest {

    @Test
    public void concatStringsWithExclamationMark() {
        final String excl = "!";
        List<String> words = List.of("lambdas", "in", "action");
        List<String> mutatedWords = concat(words, () -> excl);

        assertThat(mutatedWords.size(), is(words.size()));
        assertThat(mutatedWords, everyItem(endsWith("!")));

        // .. or with AssertJ:
        // assertThat(mutatedWords.size()).isEqualTo(words.size()); // fluent API
        // assertThat(mutatedWords).allMatch(i -> i.endsWith(excl));
    }

}

