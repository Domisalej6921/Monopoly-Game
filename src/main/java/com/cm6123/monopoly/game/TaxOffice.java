package com.cm6123.monopoly.game;

public class TaxOffice {

    /**
     * Intitialises propertyId variable.
     */
    private final int propertyId;

    /**
     * Intitialises propertyName variable.
     */
    private final String propertyName;

    /**
     * Intitialises rent variable.
     */
    private final int tax;

    /**
     *
     * contructor for the class.
     *
     * @param id
     * @param name
     * @param fine
     */
    public TaxOffice(final int id, final String name, final int fine) {
        this.propertyId = id;
        this.propertyName = name;
        this.tax = fine;
    }
}
