package com.esper.model;

// -------------------------------------------------------------------------
/**
 * This class handles the statistical analysis of the Deck the user would make.
 * The helper methods are there to allow the class to do the analysis at
 * startup.
 *
 * @author Rex Lacy
 * @version 2012.04.16
 */

public class DeckStats
{
    private Deck  deck;
    private int[] color;
    private int[] cost;
    private int[] types;


    // ----------------------------------------------------------
    /**
     * Create a new DeckStats object.
     *
     * @param deck
     *            the deck to be analyzed
     */
    public DeckStats(Deck deck)
    {
        this.deck = deck;
        color = new int[6];
        cost = new int[7];
        types = new int[7];
        calculate();
    }


    /**
     * Returns the number of red cards.
     *
     * @return the integer at the index for red cards
     */
    public int getRed()
    {
        return color[0];
    }


    /**
     * Returns the number of green cards.
     *
     * @return the integer at the index for green cards
     */
    public int getGreen()
    {
        return color[1];
    }


    /**
     * Returns the number of black cards.
     *
     * @return the integer at the index for black cards
     */
    public int getBlack()
    {
        return color[2];
    }


    /**
     * Returns the number of blue cards.
     *
     * @return the integer at the index for blue cards
     */
    public int getBlue()
    {
        return color[3];
    }


    /**
     * Returns the number of white cards.
     *
     * @return the integer at the index for white cards
     */
    public int getWhite()
    {
        return color[4];
    }


    /**
     * Returns the number of colorless cards.
     *
     * @return the integer at the index for colorless cards
     */
    public int getColorless()
    {
        return color[5];
    }


    /**
     * Returns the number of multicolor cards.
     *
     * @return the integer at the index for multicolor cards
     */
    public int getMulti()
    {
        return color[6];
    }


    /**
     * Returns the number of 0 mana cards.
     *
     * @return the integer at the index for 0 mana cards
     */
    public int getCost0()
    {
        return cost[0];
    }


    /**
     * Returns the number of 1 mana cards.
     *
     * @return the integer at the index for 1 mana cards
     */
    public int getCost1()
    {
        return cost[1];
    }


    /**
     * Returns the number of 2 mana cards.
     *
     * @return the integer at the index for 2 mana cards
     */
    public int getCost2()
    {
        return cost[2];
    }


    /**
     * Returns the number of 3 mana cards.
     *
     * @return the integer at the index for 3 mana cards
     */
    public int getCost3()
    {
        return cost[3];
    }


    /**
     * Returns the number of 4 mana cards.
     *
     * @return the integer at the index for 4 mana cards
     */
    public int getCost4()
    {
        return cost[4];
    }


    /**
     * Returns the number of 5 mana cards.
     *
     * @return the integer at the index for 5 mana cards
     */
    public int getCost5()
    {
        return cost[5];
    }


    /**
     * Returns the number of 6 mana or more cards.
     *
     * @return the integer at the index for 6 mana or more cards
     */
    public int getCost6()
    {
        return cost[6];
    }


    /**
     * Returns the number of artifact cards.
     *
     * @return the number at the index for artifacts
     */
    public int getArtifacts()
    {
        return types[0];
    }


    /**
     * Returns the number of land cards.
     *
     * @return the number at the index for land
     */
    public int getLands()
    {
        return types[1];
    }


    /**
     * Returns the number of creature cards.
     *
     * @return the number at the index for creatures
     */
    public int getCreatures()
    {
        return types[2];
    }


    /**
     * Returns the number of enchantment cards.
     *
     * @return the number at the index for enchantments
     */
    public int getEnchantments()
    {
        return types[3];
    }


    /**
     * Returns the number of instant cards.
     *
     * @return the number at the index for instants
     */
    public int getInstants()
    {
        return types[4];
    }


    /**
     * Returns the number of sorcery cards.
     *
     * @return the number at the index for sorceries
     */
    public int getSorceries()
    {
        return types[5];
    }


    /**
     * Returns the number of planeswalker cards.
     *
     * @return the number at the index for planeswalkers
     */
    public int getPlaneswalkers()
    {
        return types[6];
    }


    /**
     * Helper method to calculate the statistics in the constructor.
     */
    private void calculate()
    {
        calculateColor();
        calculateCost();
        calculateType();
    }


    /**
     * Helper method to calculate the color statistics.
     */
    private void calculateColor()
    {
        for (int i = 0; i < deck.getSize(); i++)
        {
            switch (deck.get(i).getColor())
            {
                case 'R':
                    color[0]++;
                    break;
                case 'G':
                    color[1]++;
                    break;
                case 'B':
                    color[2]++;
                    break;
                case 'U':
                    color[3]++;
                    break;
                case 'W':
                    color[4]++;
                    break;
                case 'A':
                    color[5]++;
                    break;
                case 'M':
                    color[6]++;
                    break;
            }
        }
    }


    /**
     * Helper method to calculate the mana cost statistics.
     */
    private void calculateCost()
    {
        for (int i = 0; i < deck.getSize(); i++)
        {
            switch (deck.get(i).getCost())
            {
                case 0:
                    cost[0]++;
                    break;
                case 1:
                    cost[1]++;
                    break;
                case 2:
                    cost[2]++;
                    break;
                case 3:
                    cost[3]++;
                    break;
                case 4:
                    cost[4]++;
                    break;
                case 5:
                    cost[5]++;
                    break;
                case 6:
                    cost[6]++;
                    break;
                case 7:
                    cost[6]++;
                    break;
                case 8:
                    cost[6]++;
                    break;
                case 9:
                    cost[6]++;
                    break;
                case 10:
                    cost[6]++;
                    break;
                case 11:
                    cost[6]++;
                    break;
                case 12:
                    cost[6]++;
                    break;
            }
        }
    }


    /**
     * Helper method to calculate the type statistics.
     */
    private void calculateType()
    {
        for (int i = 0; i < deck.getSize(); i++)
        {
            switch (deck.get(i).getType())
            {
                case 'A':
                    types[0]++;
                    break;
                case 'L':
                    types[1]++;
                    break;
                case 'C':
                    types[2]++;
                    break;
                case 'E':
                    types[3]++;
                    break;
                case 'I':
                    types[4]++;
                    break;
                case 'S':
                    types[5]++;
                    break;
                case 'P':
                    types[6]++;
                    break;
            }
        }
    }
}
