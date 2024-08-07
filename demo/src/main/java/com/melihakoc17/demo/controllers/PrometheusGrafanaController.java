package com.melihakoc17.demo.controllers;
//prometheus'un metrikleri toplamasına izin veren bir endpoint sağlıyor
// HTTP isteklerini (requests) işlemekle sorumlu sınıf.
import com.melihakoc17.demo.metrics.MetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PrometheusGrafanaController {

    private final MetricService metricService;

    @Autowired
    public PrometheusGrafanaController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/test")
    public String testMethod(){
        metricService.incrementCounter();
        metricService.updateGauge(1.0);
        metricService.observeHistogram(Math.random());
        metricService.recordTimer(() -> {
            // Simulate some work
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        log.error("Test error method");
        log.info("Test info method");
        return "success";
    }
}
