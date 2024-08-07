package com.melihakoc17.demo.metrics;
//metriklerin kaydedilmesi ve yönetilmesi
//Prometheus ile doğrudan etkileşime girmez.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MetricService {

    private final CounterMetric counterMetric;
    private final GaugeMetric gaugeMetric;
    private final HistogramMetric histogramMetric;
    private final SummaryMetric summaryMetric;

    @Autowired
    public MetricService(CounterMetric counterMetric, GaugeMetric gaugeMetric,
                         HistogramMetric histogramMetric, SummaryMetric summaryMetric) {
        this.counterMetric = counterMetric;
        this.gaugeMetric = gaugeMetric;
        this.histogramMetric = histogramMetric;
        this.summaryMetric = summaryMetric;
    }

    public void incrementCounter() {
        System.out.println("Incrementing counter");
        counterMetric.increment();
    }

    public void updateGauge(double value) {
        gaugeMetric.setValue(value);
    }

    public void observeHistogram(double value) {
        histogramMetric.observe(value);
    }

    public void recordTimer(Runnable runnable) {
        summaryMetric.record(runnable);
    }

    public void recordTimer(long amount, TimeUnit unit) {
        summaryMetric.record(amount, unit);
    }
}
