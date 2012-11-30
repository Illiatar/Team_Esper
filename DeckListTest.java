package com.esper.test;

import com.esper.model.Deck;
import com.esper.model.DeckList;
import java.util.NoSuchElementException;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  The test class for the doubly linked deck list.
 *
 *  @author Gosu
 *  @version Apr 29, 2012
 */
public class DeckListTest
    extends TestCase
{

    private Deck sampleDeck1;
    private Deck sampleDeck2;
    private Deck sampleDeck3;
    private DeckList testList;

    public void setUp()
    {
        sampleDeck1 = new Deck("test1", null, null);
        sampleDeck2 = new Deck("test2", null, null);
        sampleDeck3 = new Deck("test3", null, null);
        testList = new DeckList();
    }

    /**
     * Test the addDeck method to see if the method successfully adds decks
     * to the doubly linked list. Then test the remove method to remove the
     * deck from the list.
     */
    public void testAddandRemoveDeck()
    {
        testList.addDeck(sampleDeck1);
        testList.addDeck(sampleDeck2);
        testList.addDeck(sampleDeck3);
        assertEquals(3, testList.getListSize());
        testList.removeDeck(sampleDeck2);
        assertEquals(2, testList.getListSize());
        assertFalse(testList.addDeck(null));
    }


    /**
     * Test all the failure and assertion fails, in the deckList class.
     */
    public void testListFail()
    {
        assertEquals(0, testList.getListSize());
        Exception occurred = null;
        try
        {
            testList.removeDeck(sampleDeck1);
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Deck is not found.", occurred.getMessage());

        testList.addDeck(sampleDeck1);

        try
        {
            testList.removeDeck(sampleDeck2);
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Deck is not found.", occurred.getMessage());


        try
        {
            testList.getDeck(sampleDeck2);
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Deck is not found.", occurred.getMessage());


        try
        {
            testList.iterator().remove();
        }
        catch (IllegalStateException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof IllegalStateException);
        assertEquals("Next not called.", occurred.getMessage());

        try
        {
            testList.iterator().next();
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Deck List is Empty.", occurred.getMessage());

    }
}
