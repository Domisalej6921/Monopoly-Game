package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PropertyType;
import com.cm6123.monopoly.game.Stations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationsTest {

    @Test
    public void testStationsInitialization() {
        // Create test data
        PropertyType propertyType = PropertyType.Station;
        String propertyName = "Central Station";
        Player owner = null;
        int price = 300;
        int rent = 150;

        // Create a stations instance
        Stations station = new Stations(propertyName, propertyType, owner, price, rent);

        // Check if properties are initialized correctly
        assertEquals(PropertyType.Station, propertyType);
        assertEquals("Central Station", propertyName);
        assertEquals(null, owner);
        assertEquals(300, price);
        assertEquals(150, rent);
    }
}
