package com.cm6123.monopoly.game;

public class Road extends Properties{

    /**
     * Default constructor which inherits the attributes of the super class.
     * @param propertyId
     * @param propertyName
     * @param owner
     * @param price
     * @param rent
     */
    public Road(final int propertyId, final String propertyName, final Player owner, final int price, final int rent) {
        super(propertyId, propertyName, owner, price, rent);
    }
}
