package com.example.streams.parallel;

import java.util.concurrent.atomic.AtomicLong;

interface Accumulator {
    void add(long value);

    long getTotal();

    class BasicAccumulator implements Accumulator {
        private long total = 0L;

        public void add(long value) { total += value; }

        public long getTotal() {return total;}
    }

    class AtomicAccumulator implements Accumulator {
        private AtomicLong total = new AtomicLong(0);

        public void add(long value) { total.addAndGet(value); }

        public long getTotal() {return total.get();}
    }


    class SynchronizedAccumulator implements Accumulator {
        private long total = 0L;

        public void add(long value) { synchronized (this) {total += value;} }

        public long getTotal() {return total;}
    }
}