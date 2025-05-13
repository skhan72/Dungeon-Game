package org.example;
//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------

/**
 * This is an Axe item that will be used by the character
 * to help fight the monster as it increases the health
 */
public class Axe extends Item {
    /**
     *
     * @param name The name of the axe.
     * @param strengthBonus The amount of strength
     * this adds axe when it's used.
     */
    public Axe(String name, int strengthBonus) {
        super(name, strengthBonus, 0);
    }
}
