package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PropertyType;
import com.cm6123.monopoly.game.Road;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoadTest {

    @Test
    public void testRoadInitialization() {
        // Create test data
        String propertyName = "Main Road";
        PropertyType propertyType = PropertyType.Road;

        // Create a road instance
        Road road = new Road(propertyName, PropertyType.Road, new Player("TestPlayer"), 200, 20);

        // Check if properties are initialized correctly
        assertEquals("Main Road", propertyName);
        assertEquals(PropertyType.Road, propertyType);
    }
}
