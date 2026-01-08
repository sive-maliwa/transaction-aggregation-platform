package com.sive.aggregator.api.controller;

import com.sive.aggregator.core.service.AggregationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/aggregations")
public class AggregationController {

    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/by-category")
    public Map<String, BigDecimal> totalByCategory() {
        return aggregationService.totalByCategory();
    }
}