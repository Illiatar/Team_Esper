package com.esper.model;

// -------------------------------------------------------------------------
/**
 *  The Card class.
 *
 *  @version 2012.04.16
 */
public class Card
{
    // Instance/static variables ---------------------------------------------
    private char color;
    private int cost;
    private char type;
    private String name;

    // Constructor------------------------------------------------------------
    /**
     * Create a new Card object.
     *
     * @param cardName as the card's specific name
     * @param cardColor the card's color
     * @param cardType the card's specific type (artifact / creature etc)
     * @param cardCost the card's mana cost
     */
    public Card(String cardName, char cardColor, int cardCost, char cardType)
    {
        name = cardName;
        color = cardColor;
        type = cardType;
        cost = cardCost;
    }

    // Methods----------------------------------------------------------------

    /**
     * Retrieves the Card's name.
     *
     * @return the card's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retrieves the card's color.
     *
     * @return the color
     */
    public char getColor()
    {
        return color;
    }

    /**
     * Retrieves the card's type.
     *
     * @return the card's type
     */
    public char getType()
    {
        return type;
    }

    /**
     * Retrieves the mana cost of the card.
     *
     * @return the card's total mana cost.
     */
    public int getCost()
    {
        return cost;
    }

    /**
     * Compares two cards' attributes to check if they are equal.
     *
     * @param other as the specified card to compare to
     * @return true or false
     */
    public boolean equals(Card other)
    {
        if (other != null)
        {
            return (other.getName() == this.getName());
        }
        return false;
    }
}
