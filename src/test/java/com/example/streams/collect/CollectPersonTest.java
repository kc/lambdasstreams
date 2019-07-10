package com.example.streams.collect;

import org.junit.Test;

public class CollectPersonTest {
    @Test
    public void testCollect() {
        CollectPerson c = new CollectPerson();
        System.out.println(c.collectPersonNames());

    }
}