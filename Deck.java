package com.esper.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Random;

// -------------------------------------------------------------------------
/**
 * The deck class which contains a private nested ArrayList which holds card
 * objects.
 *
 * @author David H. Nguyen
 * @author Rex Lacy
 * @version Nov 30, 2012
 */

public class Deck
    extends ArrayList<Card>
{
    // Instance/static variables ---------------------------------------------
    private Random            rand;
    private ArrayList<Card>   deckList;
    private int               length;
    private String            name;
    private String            cards;
    private Database          data;
    private ArrayList<String> result;


    // Constructor -----------------------------------------------------------

    /**
     * Create a new Deck object.
     *
     * @param inputName
     *            the name for the deck
     * @param cardList
     *            the string list of each card in the deck
     * @param database
     *            the database used for the current release of cards
     */
    public Deck(String inputName, String cardList, Database database)
    {
        deckList = new ArrayList<Card>(60);
        rand = new Random();
        length = 60;
        name = inputName;
        cards = cardList;
        data = database;
        result = populate(cards);
    }


    // Methods ---------------------------------------------------------------

    private ArrayList<String> populate(String cardsA)
    {
        String delims = "[,]";
        String cardNames[] = cardsA.split(delims);
        ArrayList<String> errors = new ArrayList<String>();
        for (int i = 0; i < cardNames.length; i++)
        {
            boolean r = this.addCard(data.find(cardNames[i]));
            if (!r)
            {
                errors.add(cardNames[i]);
            }
        }
        return errors;
    }


    // ----------------------------------------------------------
    /**
     * outputs an array list of strings which return the results of running
     * populate on the deck.
     *
     * @return result the result of running populate on the deck
     */
    public ArrayList<String> getErrors()
    {
        return result;
    }


    /**
     * Adds the card to the ArrayList.
     *
     * @param input
     *            as the card to add
     * @return boolean whether the card was successfully located
     */

    public boolean addCard(Card input)
    {
        if (input == null)
        {
            return false;
        }
        if (this.getSize() == this.length)
        {
            length = length * 2;
        }
        deckList.ensureCapacity(length);
        deckList.add(input);
        return true;
    }


    /**
     * Removes a card from the deck.
     *
     * @param toRemove
     *            the specified card to be removed
     * @return the removed card
     */
    public boolean removeCard(Card toRemove)
    {
        assert toRemove != null;
        if (deckList.contains(toRemove))
        {
            return deckList.remove(toRemove);
        }
        return false;
    }


    /**
     * Searches the deck with the specific card's name and returns the card.
     *
     * @param cardName
     *            as the specified card's name
     * @return the card with the same name
     */
    public Card getCard(Card cardName)
    {
        if (deckList.contains(cardName))
        {
            return cardName;
        }
        throw new NoSuchElementException("Card not found.");
    }


    /**
     * Returns a randomized selection of seven cards within the deck.
     *
     * @return the array of seven cards.
     */
    public ArrayList<Card> goFish()
    {
        ArrayList<Integer> history = new ArrayList<Integer>(7);
        ArrayList<Card> hand = new ArrayList<Card>(7);
        while (hand.size() < 7)
        {
            int a = rand.nextInt(this.getSize());
            if (!history.contains(a))
            {
                history.add(a);
                hand.add(deckList.get(a));
            }
        }
        return hand;
    }


    /**
     * Returns the size of the deck.
     *
     * @return the size
     */
    public int getSize()
    {
        return deckList.size();
    }


    /**
     * Empties the deck.
     */
    public void clearDeck()
    {
        Iterator<Card> it = iterator();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }
    }


    /**
     * Retrieves the name for the deck.
     *
     * @return the name of the deck
     */
    public String getName()
    {
        return name;
    }


    /**
     * Puts an iterator in the Deck of Cards.
     *
     * @return the iterator that is in the stack
     */
    public Iterator<Card> iterator()
    {
        return new DeckIterator();
    }


    // ------------------------------------------------------------------------
    /**
     * A Nested ArrayList Iterator Class, that has access to all the data in the
     * Deck class.
     *
     * @author David H. Nguyen
     * @version 2012.04.01
     */
    private class DeckIterator
        implements Iterator<Card>
    {
        // Fields ---------------------------------------------------

        private int     index;
        private boolean nextIsCalled;


        // Constructor ----------------------------------------------
        /**
         * Initializes an Iterator object starting at the index of 0.
         */
        public DeckIterator()
        {
            index = 0;
        }


        // Methods --------------------------------------------------

        /**
         * Returns true or false indicating whether the array is empty or not.
         *
         * @return true or false depending on the condition
         */
        public boolean hasNext()
        {
            boolean check = false;

            if (getSize() == 0)
            {
                check = false;
            }
            else if (index != getSize())
            {
                check = true;
            }
            return check;
        }


        /**
         * Retrieves the next Card in the sequence.
         *
         * @return the next Card in the sequence
         */
        public Card next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("Deck is Empty.");
            }
            nextIsCalled = true;
            Card temp = deckList.get(index);
            index++;
            return temp;
        }


        /**
         * Returns the last Card that was returned by the next method, If next
         * was successfully called.
         */
        public void remove()
        {
            if (!nextIsCalled)
            {
                throw new IllegalStateException("Next not called.");
            }
            deckList.remove(index - 1);
            nextIsCalled = false;
            index--;
        }
    }
}
