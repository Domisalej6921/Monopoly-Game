package com.cm6123.monopoly.game;

public class Stations extends Properties{

    /**
     * Default constructor which inherits the attributes of the super class.
     * @param propertyType
     * @param propertyName
     * @param owner
     * @param price
     * @param rent
     */
    public Stations(final String propertyName, final PropertyType propertyType, final Player owner, final int price, final int rent) {
        super(propertyName, propertyType, owner, price, rent);
    }
}
