package com.cm6123.monopoly.game;

public class TaxOffice extends Properties {

    /**
     *
     * contructor for the class.
     *
     * @param propertyName
     * @param propertyType
     * @param owner
     * @param price
     * @param rent
     */
    public TaxOffice(final String propertyName, final PropertyType propertyType, final Player owner, final int price, final int rent) {
        super(propertyName, propertyType, owner, price, rent);
    }
}
