package com.example.lambdas;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecuteAroundTest {
    private ExecuteAround executeAround = new ExecuteAround();

    @Test
    public void printOneLineContainsLoremIpsum() throws IOException {
        String s = executeAround.processFile();
        assertThat(s).contains("Lorem ipsum");
    }

}
