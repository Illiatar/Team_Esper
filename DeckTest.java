package com.esper.test;

import com.esper.model.Card;
import com.esper.model.Database;
import com.esper.model.Deck;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  The deck test class.
 *
 *  @author David H. Nguyen
 *  @version Apr 16, 2012
 */
public class DeckTest
    extends TestCase
{
    private Deck testDeck;
    private Deck testDeck2;
    private Database dataB;
    private String testInput = "Arc Trail,Arc Trail,ArcTrail,Assault Strobe,Assault Strobe,Assault Strobe,Assault Strobe,Blackcleave Cliffs,Blackcleave Cliffs,Blackcleave Cliffs,Blackcleave Cliffs,Doom Blade,Doom Blade,Doom Blade,Doom Blade,Dragonskull Summit,Dragonskull Summit,Dragonskull Summit,Dragonskull Summit,Flensermite,Flensermite,Flensermite,Furnace Scamp,Furnace Scamp,Furnace Scamp,Furnace Scamp,Goblin Tunneler,Goblin Tunneler,Goblin Tunneler,Goblin Tunneler,Mountain,Mountain,Mountain,Mountain,Mountain,Mountain,Mutagenic Growth,Mutagenic Growth,Mutagenic Growth,Mutagenic Growth,Phyresis,Phyresis,Phyresis,Phyresis,Plague Stinger,Plague Stinger,Plague Stinger,Plague Stinger,Swamp,Swamp,Swamp,Swamp,Swamp,Swamp,Swamp,Swamp,Tainted Strike,Tainted Strike,Tainted Strike,Tainted Strike";

    /**
     * Initializes two new Deck class and database to get the cards.
     */
    public void setUp()
    {
        dataB = new Database();
        testDeck = new Deck("test1", testInput, dataB);
//
//        testDeck.addCard(dataB.find("Abattoir Ghoul"));
//        testDeck.addCard(dataB.find("Abbey Griffin"));
//        testDeck.addCard(dataB.find("Abuna Acolyte"));
//        testDeck.addCard(dataB.find("Accorder Paladin"));
//        testDeck.addCard(dataB.find("Accorder's Shield"));
//        testDeck.addCard(dataB.find("Acid Web Spider"));
//        testDeck.addCard(dataB.find("Acidic Slime"));
//        testDeck.addCard(dataB.find("Act of Aggression"));
//        testDeck.addCard(dataB.find("Act of Treason"));
//        testDeck.addCard(dataB.find("Adaptive Automaton"));
//        testDeck.addCard(dataB.find("Aegis Angel"));
//        testDeck.addCard(dataB.find("AEther Adept"));
//        testDeck.addCard(dataB.find("Afflicted Deserter/Werewolf Ransacker"));
//        testDeck.addCard(dataB.find("Alabaster Mage"));
//        testDeck.addCard(dataB.find("Alloy Myr"));
//        testDeck.addCard(dataB.find("Alluring Siren"));
//        testDeck.addCard(dataB.find("Alpha Brawl"));
//        testDeck.addCard(dataB.find("Alpha Tyrranax"));
//        testDeck.addCard(dataB.find("Altar of the Lost"));
//        testDeck.addCard(dataB.find("Altar's Reap"));
//        testDeck.addCard(dataB.find("Ambush Viper"));
//        testDeck.addCard(dataB.find("Amphin Cutthroat"));
//        testDeck.addCard(dataB.find("Ancient Grudge"));
//        testDeck.addCard(dataB.find("Angel of Flight Alabaster"));
//        testDeck.addCard(dataB.find("Angelic Destiny"));
//        testDeck.addCard(dataB.find("Angelic Overseer"));
//        testDeck.addCard(dataB.find("Angel's Feather"));
//        testDeck.addCard(dataB.find("Angel's Mercy"));
//        testDeck.addCard(dataB.find("Apostle's Blessing"));
//        testDeck.addCard(dataB.find("Arachnus Spinner"));
//        testDeck.addCard(dataB.find("Arachnus Web"));
//        testDeck.addCard(dataB.find("Arbalest Elite"));
//        testDeck.addCard(dataB.find("Arc Trail"));
//        testDeck.addCard(dataB.find("Archangel's Light"));
//        testDeck.addCard(dataB.find("Archon of Justice"));
//        testDeck.addCard(dataB.find("Ardent Recruit"));
//        testDeck.addCard(dataB.find("Argent Mutation"));
//        testDeck.addCard(dataB.find("Argent Sphinx"));
//        testDeck.addCard(dataB.find("Argentum Armor"));
//        testDeck.addCard(dataB.find("Arm with AEther"));
//        testDeck.addCard(dataB.find("Armored Skaab"));
//        testDeck.addCard(dataB.find("Armored Warhorse"));
//        testDeck.addCard(dataB.find("Army of the Damned"));
//        testDeck.addCard(dataB.find("Arrest"));
//        testDeck.addCard(dataB.find("Artful Dodge"));
//        testDeck.addCard(dataB.find("Artillerize"));
//        testDeck.addCard(dataB.find("Asceticism"));
//        testDeck.addCard(dataB.find("Ashmouth Hound"));
//        testDeck.addCard(dataB.find("Assault Griffin"));
//        testDeck.addCard(dataB.find("Assault Strobe"));
//        testDeck.addCard(dataB.find("Auramancer"));
//        testDeck.addCard(dataB.find("Auriok Edgewright"));
//        testDeck.addCard(dataB.find("Auriok Replica"));
//        testDeck.addCard(dataB.find("Auriok Sunchaser"));
//        testDeck.addCard(dataB.find("Auriok Survivors"));
//        testDeck.addCard(dataB.find("Autumn's Veil"));
//        testDeck.addCard(dataB.find("Avacynian Priest"));
//        testDeck.addCard(dataB.find("Avacyn's Collar"));
    }


    /**
     * Tests the addCard method.
     */
    public void testOnCreate()
    {
        assertTrue(testDeck.contains(dataB.find("Arc Trail")));
    }

    /**
     * Tests the remove Card method.
    */
    public void testRemoveCard()
    {
        assertEquals(60, testDeck.getSize());
        testDeck.removeCard(dataB.find("Arc Trail"));
        assertEquals(59, testDeck.getSize());

        Card tC = new Card("1", 'R', 3, '4');
        // tC = dataB.find("Zombie Infestation");
        assertFalse(testDeck.removeCard(tC));
        testDeck.clearDeck();
        assertEquals(0, testDeck.getSize());
    }

    /**
     * tests theGoFish method.
    */
    public void testGoFish()
    {
        assertEquals(testDeck.goFish().size(), 7);
    }


    /**
     * Tests the to see if the get name method returns the name or not.
     */
    public void testGetName()
    {
        assertEquals(testDeck.getName(), "test1");
    }

    /**
     * tests to see if the next and remove method of the Array iterator fails.
     */
    public void testArrayFail()
    {
        Exception occurred = null;
        try
        {
            testDeck2.iterator().remove();
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
            testDeck2.iterator().next();
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Deck is Empty.", occurred.getMessage());

        Card tC = new Card("A", 'B', 3, 'D');
        try
        {
            testDeck2.getCard(tC);
        }
        catch (NoSuchElementException exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Card not found.", occurred.getMessage());
    }
}