package com.cm6123.monopoly.dice;

public class Dice {

  /**
   * The number of faces on this dice.
   */
  private static Integer faces;

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
  public static Integer roll() {
    Double tempRoll = Math.ceil(Math.random() * faces.doubleValue());
    return tempRoll.intValue();
  }

    /**
     * Processes the rolling of two dice.
     * @return the value of both rolls.
     */
  public static int[] rollTwoDice() {
    int roll1 = roll();
    int roll2 = roll();

    int[] roll = {roll1, roll2};

    return roll;
  }

    /**
     * checks the value of the users roll to use elsewhere.
     * @param roll
     * @return a boolean if double is true or not.
     */
  public static Boolean checkForDouble(final int[] roll) {
      // Check if both dice have the same value
      Boolean doubleRoll = null;
      if (roll[0] % 2 == 0 && roll[1] % 2 == 0) {
          System.out.println("\nBoth dice rolled the same value." + roll[0] + " " + roll[1] + "!\n");
          doubleRoll = true;
      }
      return doubleRoll;
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
