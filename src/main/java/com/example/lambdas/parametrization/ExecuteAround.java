package com.example.lambdas.parametrization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExecuteAround {
    public String processFile() throws IOException, URISyntaxException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data.txt")));) {
            String oneLineFromFile = br.readLine(); // this should be parameterized
            System.out.println(oneLineFromFile); // this one too?
            return oneLineFromFile;
        }
    }
}
