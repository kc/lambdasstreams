package com.example.streams.collect;

import org.junit.Test;

public class CollectPersonTest {
    CollectPerson c = new CollectPerson();

    @Test
    public void testCollect() {
        System.out.println(c.collectPersonNames());
    }


    @Test
    public void testReduce() {
        System.out.println(c.reducePersonNames());
    }
}