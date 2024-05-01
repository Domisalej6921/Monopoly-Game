package com.cm6123.monopoly;

import com.cm6123.monopoly.game.TaxOffice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxOfficeTest {

    @Test
    public void testTaxOfficeInitialization() {
        // Create test data
        int propertyId = 4;
        String propertyName = "Main Tax Office";
        int fine = 200;

        // Create a tax office instance
        TaxOffice taxOffice = new TaxOffice(propertyId, propertyName, fine);

        // Check if properties are initialized correctly
        assertEquals(4, propertyId);
        assertEquals("Main Tax Office", propertyName);
        assertEquals(200, fine);
    }
}
