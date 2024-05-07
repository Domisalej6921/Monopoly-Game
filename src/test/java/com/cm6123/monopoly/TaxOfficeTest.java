package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PropertyType;
import com.cm6123.monopoly.game.TaxOffice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxOfficeTest {

    @Test
    public void testTaxOfficeInitialization() {
        // Create test data
        String propertyName = "Main Tax Office";
        PropertyType type = PropertyType.TaxOffice;
        Player owner = null;
        int price = 0;
        int rent =0;

        // Create a tax office instance
        TaxOffice taxOffice = new TaxOffice(propertyName, type, null, price, rent);

        // Check if properties are initialized correctly
        assertEquals("Main Tax Office", propertyName);
        assertEquals(PropertyType.TaxOffice, type);
        assertEquals(null, owner);
        assertEquals(0, price);
        assertEquals(0, rent);
    }
}
