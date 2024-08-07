package com.melihakoc17.demo.metrics;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SummaryMetric {

    private final Timer exampleTimer;

    public SummaryMetric(MeterRegistry registry) {
        this.exampleTimer = Timer.builder("example_timer_seconds")
                .description("An example timer")
                .register(registry);
    }

    public void record(Runnable runnable) {
        exampleTimer.record(runnable);
    }

    public void record(long amount, TimeUnit unit) {
        exampleTimer.record(amount, unit);
    }

    public long count() {
        return exampleTimer.count();
    }

    public double totalTime() {
        return exampleTimer.totalTime(TimeUnit.SECONDS);
    }

    public double max() {
        return exampleTimer.max(TimeUnit.SECONDS);
    }
}
