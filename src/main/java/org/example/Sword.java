//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------
package org.example;
/**
 * The {@code Sword} class represents an item
 * that enhances a character's strength.
 * It is a subclass of {@link Item} and only provides a strength bonus.
 *
 */
public class Sword extends Item {
    /**
     * Constructs a new {@code Sword} with the
     * specified name and strength bonus.
     *
     * @param name the name of the sword
     * @param strengthBonus the strength
     * this is bonus provided by the iron sword
     */
    public Sword(final String name, final int strengthBonus) {
        super(name, strengthBonus, 0);  // Strength only
    }
}