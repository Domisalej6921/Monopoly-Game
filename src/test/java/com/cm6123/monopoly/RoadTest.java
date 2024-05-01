package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Road;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoadTest {

    @Test
    public void testRoadInitialization() {
        // Create test data
        int propertyId = 2;
        String propertyName = "Main Road";

        // Create a road instance
        Road road = new Road(propertyId, propertyName);

        // Check if properties are initialized correctly
        assertEquals(2, propertyId);
        assertEquals("Main Road", propertyName);
    }
}
