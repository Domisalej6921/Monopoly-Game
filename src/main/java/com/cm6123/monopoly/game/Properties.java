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
     * Initialises the property attribute.
     */
    private Properties property = null;

    /**
     * Initialises the propertyType attribute.
     */
    private PropertyType propertyType;

    /**
     * Initialises the owner attribute.
     */
    protected Player playerOwner;

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
        this.property = this;
        this.playerOwner = owner;
        this.propertyPrice = price;
        this.propertyRent = rent;
    }

    /**
     * Get the property name.
     *
     * @param propertyInstance
     *
     * @return propertyName.
     */
    public static String getPropertyName(final Properties propertyInstance) {
        return propertyInstance.propertyName;
    }

    /**
     * Get the property instance.
     *
     * @return property
     */
    public Properties getProperty() {
        return this.property;
    }

    /**
     * Get the owner.
     * @return playerOwner.
     */
    public PropertyType getPropertyType() {
        return this.propertyType;
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
        int numOfRoads = (int) (numOfSpaces * 0.4);
        int numOfStations = (int) (numOfSpaces * 0.3);
        int numOfTaxOffices = (int) (numOfSpaces * 0.1);
        int numOfProperties = numOfSpaces - numOfRoads - numOfStations - numOfTaxOffices;

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
            int price = 10;
            int rent = 0;
            PropertyType type = PropertyType.Station;
            Properties property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }

        //Creates a tax office
        for (int i = 0; i < numOfTaxOffices; i++) {
            String name = "Tax Office ";
            Player owner = null;
            int price = 0;
            int rent = 0;
            PropertyType type = PropertyType.TaxOffice;
            Properties property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }

        for (int i = 0; i < numOfProperties; i++) {
            String name = propertyNames[random.nextInt(propertyNames.length)];
            Player owner = null;
            int price = random.nextInt(400) + 100;
            int rent = (int) round(price * 0.1);
            PropertyType type = PropertyType.Property;
            Properties property = new Properties(name, type, owner, price, rent);
            properties.add(property);
        }
        return properties;
    }

    /**
     * Get the price of the property.
     * @return propertyPrice.
     */
    public int getPrice() {
        return propertyPrice;
    }

    /**
     * Get the rent of the property.
     * @return propertyRent.
     */
    public int getRent() {
        return propertyRent;
    }

    /**
     * Changes the owner of a property.
     * @param newOwner
     */
    public void changeOwner(final Player newOwner) {
        this.playerOwner = newOwner;
    }
}
