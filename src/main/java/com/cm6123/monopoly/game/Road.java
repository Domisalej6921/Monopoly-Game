package com.cm6123.monopoly.game;

public final class Road {

    /**
     * initialises the propertyId variable.
     */
    private final int propertyId;

    /**
     * Initialises the propertyName variable.
     */
    private final String propertyName;

    /**
     * Default constructor which inherits the attributes of the super class.
     * @param id
     * @param name
     */
    public Road(final int id, final String name) {
        this.propertyId = id;
        this.propertyName = name;
    }

    /**
     * Returns the name of the space so it can be displayed on the board.
     * @return String Road
     */
    public static String getRoadName() {
        return "Road";
    }
}
