package com.sive.ingestion.core.categorizer;

import org.springframework.stereotype.Component;

@Component
public class RuleCategorizer {

    public String categorize(String description) {
        if (description == null) {
            return "UNKNOWN";
        }

        String d = description.toLowerCase();

        if (d.contains("uber") || d.contains("taxi")) {
            return "TRANSPORT";
        }

        if (d.contains("woolworths")
                || d.contains("food")
                || d.contains("grocery")
                || d.contains("supermarket")
                || d.contains("store")) {
            return "GROCERIES";
        }

        if (d.contains("rent")) {
            return "HOUSING";
        }

        return "OTHER";
    }
}

