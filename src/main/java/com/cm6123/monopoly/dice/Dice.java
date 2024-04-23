package com.cm6123.monopoly.dice;

public class Dice {

  /**
   * The number of faces on this dice.
   */
  private Integer faces;

  /**
   * Construct a dice with the given number of faces.
   *
   * @param numberOfFaces the number of faces that the dice will have.  Dice rolls 1 to this number.
   */
  public Dice(final Integer numberOfFaces) {
    this.faces = numberOfFaces;
  }

  /**
   * Roll to dice to get a value.
   *
   * @return an integer between 1 and the number of faces inclusive.
   */
  public Integer roll() {
    Double tempRoll = Math.ceil(Math.random() * faces.doubleValue());
    return tempRoll.intValue();
  }

  /**
   * Get the number of faces on this dice.
   *
   * @return the number of faces on this dice.
   */
  public Integer getFaces() {
    return faces;
  }

}
