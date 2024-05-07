package com.cm6123.monopoly;

import com.cm6123.monopoly.game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesChecks {

    @Test
    public void testPropertiesInitialization() {
        // Create test data
        String propertyName = "Main Street";
        PropertyType propertyType = PropertyType.Property;
        Player owner = null;
        int price = 500;
        int rent = 50;

        // Create a properties instance
        Properties property = new Properties(propertyName, propertyType, owner, price, rent);

        // Check if properties are initialized correctly
        assertEquals(PropertyType.Property, propertyType);
        assertEquals("Main Street", propertyName);
        assertEquals(null, owner);
        assertEquals(500, price);
        assertEquals(50, rent);
    }
}
