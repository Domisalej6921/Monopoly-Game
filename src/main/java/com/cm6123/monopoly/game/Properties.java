package com.cm6123.monopoly.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

public class Properties {

    /**
     * Initialises the propertyName attribute.
     */
    private final String propertyName;

    /**
     * Initialises the propertyType attribute.
     */
    private PropertyType propertyType;

    /**
     * Initialises the owner attribute.
     */
    private final Player playerOwner;

    /**
     * Initialises the price attribute.
     */
    private final int propertyPrice;

    /**
     * Initialises the rent attribute.
     */
    private final int propertyRent;

    /**
     * Default constructor.
     * @param name
     * @param type
     * @param owner
     * @param price
     * @param rent
     */
    public Properties(final String name, final PropertyType type, final Player owner, final int price, final int rent) {
        this.propertyName = name;
        this.propertyType = type;
        this.playerOwner = owner;
        this.propertyPrice = price;
        this.propertyRent = rent;
    }

    /**
     * Get the property name.
     * @return propertyName.
     */
    public String getPropertyName() {
        return this.propertyName;
    }

    /**
     * Get the properties list.
     *
     * @param numOfSpaces
     *
     * @return properties.
     */
    public static List<Properties> getProperties(final int numOfSpaces) {
        List<Properties> properties = new ArrayList<>();
        Random random = new Random();
        String[] propertyNames = {"Main Street", " Broadway  ", " Park Lane ", "Bond Street", "Oxford View", "Regent Road", "Piccadilly "};

        //Calculate the number of properties to be created
        int numOfRoads = numOfSpaces / 5;
        int numOfStations = numOfSpaces / 10;
        int numOfTaxOffices = 1;

        //list of road spaces
        for (int i = 0; i < numOfRoads; i++) {
            String name = "   Road    ";
            Player owner = null;
            int price = 0;
            int rent = 0;
            PropertyType type = PropertyType.Road;
            Properties property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }

        //Creates a list of stations
        for (int i = 0; i < numOfStations; i++) {
            String name= "  Station  ";
            Player owner = null;
            int price = 0;
            int rent = 0;
            PropertyType type = PropertyType.Station;
            Properties property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }

        //Creates a tax office
        String name = "Tax Office ";
        Player owner = null;
        int price = 0;
        int rent = 0;
        PropertyType type = PropertyType.TaxOffice;
        Properties property = new Properties(name, type, owner, price, rent);
        properties.add(property);

        while (properties.size() < numOfSpaces) {
            name = propertyNames[random.nextInt(propertyNames.length)];
            owner = null;
            price = random.nextInt(400) + 100;
            rent = (int) round(price * 0.1);
            type = PropertyType.values()[random.nextInt(PropertyType.values().length)];
            property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }
        return properties;
    }
}
