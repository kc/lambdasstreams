package com.example.lambdas.parametrization.apples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppleServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void shouldPrintApples() {
        List<Apple> apples = List.of(
                new Apple("red", 150),
                new Apple("green", 180),
                new Apple("red", 85)
        );
        AppleService service = new AppleService();
        service.consumeApples(apples, new ApplePrinter());

        String expected = "Apple Color: red, Weight: 150" + System.lineSeparator() +
                "Apple Color: green, Weight: 180" + System.lineSeparator() +
                "Apple Color: red, Weight: 85" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }
}