package com.sive.ingestion.core.categorizer;

/*package com.sive.ingestion.core.categorizer;*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleCategorizerTest {

    private RuleCategorizer categorizer;

    @BeforeEach
    void setUp() {
        categorizer = new RuleCategorizer();
    }

    @Test
    void shouldCategorizeTransport() {
        assertEquals("TRANSPORT", categorizer.categorize("Uber trip to airport"));
    }

    @Test
    void shouldCategorizeGroceries() {
        assertEquals("GROCERIES",
                categorizer.categorize("Weekly grocery shopping at Woolworths"));
    }

    @Test
    void shouldCategorizeHousing() {
        assertEquals("HOUSING", categorizer.categorize("January rent payment"));
    }

    @Test
    void shouldBeCaseInsensitive() {
        assertEquals("GROCERIES",
                categorizer.categorize("FOOD from SUPERMARKET"));
    }

    @Test
    void shouldReturnOtherForUnknownDescription() {
        assertEquals("OTHER", categorizer.categorize("Movie tickets"));
    }

    @Test
    void shouldReturnUnknownWhenDescriptionIsNull() {
        assertEquals("UNKNOWN", categorizer.categorize(null));
    }
}