package com.example.lambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteAround {
    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data.txt")))) {
            String oneLineFromFile = br.readLine(); // this should be parameterized
            System.out.println(oneLineFromFile); // this one too?
            return oneLineFromFile;
        }
    }
}
