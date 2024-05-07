package com.cm6123.monopoly.game;

public final class Road extends Properties {

    /**
     * Default constructor which inherits the attributes of the super class.
     *
     * @param propertyName
     * @param propertyType
     * @param owner
     * @param price
     * @param rent
     */
    public Road(final String propertyName, final PropertyType propertyType, final Player owner, final int price, final int rent) {
        super(propertyName, propertyType, owner, price, rent);
    }

    /**
     * Returns the name of the space so it can be displayed on the board.
     * @return String Road
     */
    public static String getRoadName() {
        return "Road";
    }
}
