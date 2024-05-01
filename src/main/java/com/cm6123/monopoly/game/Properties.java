package com.cm6123.monopoly.game;

public class Properties {

    /**
     * Initialises the propertyId attribute.
     */
    private final int propertyId;

    /**
     * Initialises the propertyName attribute.
     */
    private final String propertyName;

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
     * @param id
     * @param name
     * @param owner
     * @param price
     * @param rent
     */
    public Properties(final int id, final String name, final Player owner, final int price, final int rent) {
        this.propertyId = id;
        this.propertyName = name;
        this.playerOwner = owner;
        this.propertyPrice = price;
        this.propertyRent = rent;
    }
}
