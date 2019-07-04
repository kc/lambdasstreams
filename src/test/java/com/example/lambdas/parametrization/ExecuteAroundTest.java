package com.example.lambdas.parametrization;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ExecuteAroundTest {
    ExecuteAround executeAround = new ExecuteAround();

    @Test
    public void test() throws IOException, URISyntaxException {
        executeAround.processFile();
    }


}
