package com.esper.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;


// -------------------------------------------------------------------------
/**
 *  A Doubly linked list which holds the deck.
 *
 *  @author David H. Nguyen
 *  @version Apr 18, 2012
 */
public class DeckList extends LinkedList<Deck>
{
    private Node<Deck> head;
    private Node<Deck> tail;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new DeckList object.
     */
    public DeckList()
    {
        head = new Node<Deck>(null);
        tail = new Node<Deck>(null);
        head.combine(tail);
        size = 0;
    }

    // Methods --------------------------------------------------

    /**
     * Inserts a deck into the back of the LinkedList.
     *
     * @param insert as the specified deck to be added
     * @return true or false, depending if the deck was successfully added
     */
    public boolean addDeck(Deck insert)
    {
        Node<Deck> temp = new Node<Deck>(insert);
        if (temp.getData() != null)
        {
            tail.getPrev().combine(temp);
            temp.combine(tail);
            size++;
            return true;
        }
        return false;
    }


    /**
     * Removes the deck from the linked list.
     *
     * @param remove the deck that is to be removed
     * @return the deck that was removed
     */
    public Deck removeDeck(Deck remove)
    {
        Iterator<Deck> it = iterator();
        while(it.hasNext())
        {
            if (it.next().equals(remove))
            {
                it.remove();
                return remove;
            }
        }
        throw new NoSuchElementException("Deck is not found.");
    }


    /**
     * Retrieves the specified deck from the list.
     * @param input as the deck that is being retrieved
     * @return the deck if it is in the list
     */
    public Deck getDeck(Deck input)
    {
        Iterator<Deck> it = iterator();
        while(it.hasNext())
        {
            if (it.next().equals(input))
            {
                return input;
            }
        }
        throw new NoSuchElementException("Deck is not found.");
    }


    /**
     * Returns the number of decks within the Linked List.
     *
     * @return the size of the list
     */
    public int getListSize()
    {
        return size;
    }


    /**
     * Creates a new iterator for the LinkedLIst.
     *
     * @return the iterator that is in the LinkedLIst.
     */
    @Override
    public Iterator<Deck> iterator()
    {
        return new LinkedIterator(head.getNext());
    }


    /**
     * The node is used to represent each Deck in the stack with a generic data
     * type and a pointer to another Node.
     *
     * @author David H. Nguyen
     * @version 2012.04.02
     * @param <Deck>
     *            the type of element that is contained in the node.
     */
    @SuppressWarnings("hiding")
    private static class Node<Deck>
    {
        // Fields ---------------------------------------------------
        private Deck data;
        private Node<Deck> next;
        private Node<Deck> prev;


        // Constructor ----------------------------------------------
        /**
         * Creates a node with a reference to a "next" node
         *
         * @param value data to be stored in node
         */
        private Node(Deck value)
        {
            data = value;
            next = null;
            prev = null;
        }


        // Methods --------------------------------------------------
        /**
         * Retrieves the data from the specified node.
         *
         * @return the specified data
         */
        private Deck getData()
        {
            return data;
        }


        /**
         * Retrieves the node that is being pointed at by the current code.
         *
         * @return the next node.
         */
        private Node<Deck> getNext()
        {
            return next;
        }


        /**
         * Sets the input node node as the next pointer to the current node.
         *
         * @param nextNode as the specified node
         */
        private void setNext(Node<Deck> nextNode)
        {
            next = nextNode;
        }


        /**
         * Retrieves the node that was set previous to the current
         *
         * @return the previous node.
         */
        private Node<Deck> getPrev()
        {
            return prev;
        }


        /**
         * Sets the previous of the current node as the specified node.
         *
         * @param prevNode as the specified node
         */
        private void setPrev(Node<Deck> prevNode)
        {
            prev = prevNode;
        }


        /**
         * Combines Nodes (sets the current node's next to the specified node
         * and sets the specified node's previous to the current node)
         *
         * @param nextNode as the specified node
         */
        private void combine(Node<Deck> nextNode)
        {
            this.setNext(nextNode);
            nextNode.setPrev(this);
        }
    }


    /**
     * A Nested LinkedIterator class, which has access to all the data in the
     * DeckList class.
     *
     * @author David H. Nguyen
     * @version 2012.04.18
     */
    private class LinkedIterator
        implements Iterator<Deck>
    {
        // Fields ---------------------------------------------------

        private Node<Deck> start;
        private boolean    nextCheck;


        // Constructor ----------------------------------------------

        /**
         * Initializes a new Iterator which begins at the that is retrieved by
         * head.next(), essentially the first non null node.
         *
         * @param begin as the specified start node
         */
        public LinkedIterator(Node<Deck> begin)
        {
            start = begin;
        }


        // Methods --------------------------------------------------

        /**
         * Checks to see if the LinkedList is empty or not
         *
         * @return true or false depending on the condition of the LinkedList
         */
        public boolean hasNext()
        {
            return start != tail;
        }


        /**
         * Retrieves the next Deck in the sequence.
         *
         * @return the next Deck
         */
        public Deck next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("Deck List is Empty.");
            }
            Deck data = start.getData();
            start = start.getNext();
            nextCheck = true;
            return data;
        }


        /**
         * Returns the last Deck that was returned by the next method, IF next
         * was successfully called.
         */
        public void remove()
        {
            if (!nextCheck)
            {
                throw new IllegalStateException("Next not called.");
            }
            start.setPrev(start.getPrev().getPrev());
            start.getPrev().setNext(start);
            size--;
        }
    }
}