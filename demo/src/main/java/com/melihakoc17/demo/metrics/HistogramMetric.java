package com.melihakoc17.demo.metrics;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class HistogramMetric {

    private final DistributionSummary exampleHistogram;

    public HistogramMetric(MeterRegistry registry) {
        this.exampleHistogram = DistributionSummary.builder("example_histogram")
                .description("An example histogram")
                .register(registry);
    }

    public void observe(double value) {
        exampleHistogram.record(value);
    }

    public double count() {
        return exampleHistogram.count();
    }

    public double totalAmount() {
        return exampleHistogram.totalAmount();
    }

    public double max() {
        return exampleHistogram.max();
    }
}
