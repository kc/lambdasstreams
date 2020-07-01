package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingSupplier.concat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsingSupplierTest {

    @Test
    public void concatStringsWithExclamationMark() {
        List<String> words = List.of("lambdas", "in", "action");
        List<String> mutatedWords = concat(words, () -> "!");

        assertThat(mutatedWords.size(), is(words.size()));
        assertThat(mutatedWords, everyItem(endsWith("!")));
    }

}

