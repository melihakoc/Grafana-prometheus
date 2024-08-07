package com.melihakoc17.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CounterMetric {

    private final Counter counter;

    public CounterMetric(MeterRegistry registry) {
        this.counter = Counter.builder("example_counter_total")
                .description("An example counter")
                .register(registry);
    }

    public void increment() {
        this.counter.increment();
    }

    public double count() {
        return counter.count();
    }
}
