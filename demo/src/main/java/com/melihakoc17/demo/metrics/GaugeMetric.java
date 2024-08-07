package com.melihakoc17.demo.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
//CPU yükü, aktif kullanıcı sayısı gibi metrikler izleniyor
@Setter
@Getter
@Component
public class GaugeMetric {

    private double value;

    public GaugeMetric(MeterRegistry meterRegistry) {
        Gauge.builder("example_gauge", this, GaugeMetric::getValue)
                .register(meterRegistry);
    }

}
