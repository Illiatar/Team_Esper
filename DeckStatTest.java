package com.esper.test;

import com.esper.model.Database;
import com.esper.model.Deck;
import com.esper.model.DeckStats;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the DeckStat class and its methods.
 *
 * @author rela
 * @version 2012.04.18
 */

public class DeckStatTest
    extends TestCase
{
    private DeckStats stats;
    private DeckStats eStats;
    private Deck      eDeck;
    private Deck      deck;
    private Database  database;


    // ----------------------------------------------------------
    /**
     * Create a new DeckStatTest object.
     */
    public DeckStatTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    /**
     * Creates two decks and a DeckStats class object to run the tests on.
     */
    public void setUp()
    {
        database = new Database();
        deck = new Deck("test1", null, database);
        deck.addCard(database.find("Abattoir Ghoul"));
        deck.addCard(database.find("Abbey Griffin"));
        deck.addCard(database.find("Abuna Acolyte"));
        deck.addCard(database.find("Accorder Paladin"));
        deck.addCard(database.find("Accorder's Shield"));
        deck.addCard(database.find("Acid Web Spider"));
        deck.addCard(database.find("Acidic Slime"));
        deck.addCard(database.find("Act of Aggression"));
        deck.addCard(database.find("Act of Treason"));
        deck.addCard(database.find("Adaptive Automaton"));
        deck.addCard(database.find("Aegis Angel"));
        deck.addCard(database.find("AEther Adept"));
        deck.addCard(database.find("Afflicted Deserter/Werewolf Ransacker"));
        deck.addCard(database.find("Alabaster Mage"));
        deck.addCard(database.find("Alloy Myr"));
        deck.addCard(database.find("Alluring Siren"));
        deck.addCard(database.find("Alpha Brawl"));
        deck.addCard(database.find("Alpha Tyrranax"));
        deck.addCard(database.find("Altar of the Lost"));
        deck.addCard(database.find("Altar's Reap"));
        deck.addCard(database.find("Ambush Viper"));
        deck.addCard(database.find("Amphin Cutthroat"));
        deck.addCard(database.find("Ancient Grudge"));
        deck.addCard(database.find("Angel of Flight Alabaster"));
        deck.addCard(database.find("Angelic Destiny"));
        deck.addCard(database.find("Angelic Overseer"));
        deck.addCard(database.find("Angel's Feather"));
        deck.addCard(database.find("Angel's Mercy"));
        deck.addCard(database.find("Apostle's Blessing"));
        deck.addCard(database.find("Arachnus Spinner"));
        deck.addCard(database.find("Arachnus Web"));
        deck.addCard(database.find("Arbalest Elite"));
        deck.addCard(database.find("Arc Trail"));
        deck.addCard(database.find("Archangel's Light"));
        deck.addCard(database.find("Archon of Justice"));
        deck.addCard(database.find("Ardent Recruit"));
        deck.addCard(database.find("Argent Mutation"));
        deck.addCard(database.find("Argent Sphinx"));
        deck.addCard(database.find("Argentum Armor"));
        deck.addCard(database.find("Arm with AEther"));
        deck.addCard(database.find("Armored Skaab"));
        deck.addCard(database.find("Armored Warhorse"));
        deck.addCard(database.find("Army of the Damned"));
        deck.addCard(database.find("Arrest"));
        deck.addCard(database.find("Artful Dodge"));
        deck.addCard(database.find("Artillerize"));
        deck.addCard(database.find("Asceticism"));
        deck.addCard(database.find("Ashmouth Hound"));
        deck.addCard(database.find("Assault Griffin"));
        deck.addCard(database.find("Assault Strobe"));
        deck.addCard(database.find("Auramancer"));
        deck.addCard(database.find("Auriok Edgewright"));
        deck.addCard(database.find("Auriok Replica"));
        deck.addCard(database.find("Auriok Sunchaser"));
        deck.addCard(database.find("Auriok Survivors"));
        deck.addCard(database.find("Autumn's Veil"));
        deck.addCard(database.find("Avacynian Priest"));
        deck.addCard(database.find("Avacyn's Collar"));
        deck.addCard(database.find("Avacyn's Pilgrim"));
        deck.addCard(database.find("Aven Fleetwing"));

        eDeck = new Deck("test2", null, database);
        eDeck.addCard(database.find("Aven Fleetwing"));

        eStats = new DeckStats(eDeck);
        stats = new DeckStats(deck);
    }


    // ----------------------------------------------------------
    /**
     * Tests to see that no deck stats object can be made if the deck is not the
     * right size yet.
     */
    public void testBadDeck()
    {
        assertNull(eStats);
    }


    /**
     * Tests the GetRed method.
     */
    public void testGetRed()
    {
        assertEquals(stats.getRed(), 0);
    }


    /**
     * Tests the GetGreen method.
     */
    public void testGetGreen()
    {
        assertEquals(stats.getGreen(), 0);
    }


    /**
     * Tests the GetBlack method.
     */
    public void testGetBlack()
    {
        assertEquals(stats.getBlack(), 3);
    }


    /**
     * Tests the GetBlue method.
     */
    public void testGetBlue()
    {
        assertEquals(stats.getBlue(), 0);
    }


    /**
     * Tests the GetWhite method.
     */
    public void testGetWhite()
    {
        assertEquals(stats.getWhite(), 0);
    }


    /**
     * Tests the GetColorless method.
     */
    public void testGetColorless()
    {
        assertEquals(stats.getColorless(), 0);
    }


    /**
     * Tests the GetMulti method.
     */
    public void testGetMulti()
    {
        assertEquals(stats.getMulti(), 0);
    }


    /**
     * Tests the getCost0 method.
     */
    public void testGetCost0()
    {
        assertEquals(stats.getCost0(), 0);
    }


    /**
     * Tests the getCost1 method.
     */
    public void testGetCost1()
    {
        assertEquals(stats.getCost1(), 0);
    }


    /**
     * Tests the getCost2 method.
     */
    public void testGetCost2()
    {
        assertEquals(stats.getCost2(), 0);
    }


    /**
     * Tests the getCost3 method.
     */
    public void testGetCost3()
    {
        assertEquals(stats.getCost3(), 0);
    }


    /**
     * Tests the getCost4 method.
     */
    public void testGetCost4()
    {
        assertEquals(stats.getCost4(), 0);
    }


    /**
     * Tests the getCost5 method.
     */
    public void testGetCost5()
    {
        assertEquals(stats.getCost5(), 0);
    }


    /**
     * Tests the getCost6 method.
     */
    public void testGetCost6()
    {
        assertEquals(stats.getCost6(), 0);
    }


    /**
     * Tests the getArtifacts method
     */
    public void testGetArtifacts()
    {
        assertEquals(stats.getArtifacts(), 0);
    }


    /**
     * Tests the getLands method
     */
    public void testGetLands()
    {
        assertEquals(stats.getLands(), 0);
    }


    /**
     * Tests the getCreatures method
     */
    public void testGetCreatures()
    {
        assertEquals(stats.getCreatures(), 0);
    }


    /**
     * Tests the getEnchantments method
     */
    public void testGetEnchantments()
    {
        assertEquals(stats.getEnchantments(), 0);
    }


    /**
     * Tests the getInstants method
     */
    public void testGetInstants()
    {
        assertEquals(stats.getInstants(), 0);
    }


    /**
     * Tests the getSorceries method
     */
    public void testGetSorceries()
    {
        assertEquals(stats.getSorceries(), 0);
    }


    /**
     * Tests the getPlaneswalkers method
     */
    public void testGetPlaneswalkers()
    {
        assertEquals(stats.getPlaneswalkers(), 0);
    }

}
