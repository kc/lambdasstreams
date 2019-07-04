package com.example.lambdas;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ExecuteAroundTest {
    private ExecuteAround executeAround = new ExecuteAround();

    @Test
    public void test() throws IOException, URISyntaxException {
        executeAround.processFile();
    }


}
