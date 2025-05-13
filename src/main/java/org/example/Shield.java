package org.example;
/**
 * The {@code Shield} class represents a protective
 * item that enhances a character's strength.
 * It is a subclass of {@link Item} and
 * provides a strength bonus only.
 *
 */
public class Shield extends Item {
    /**
     * Constructs a new {@code Shield} with the
     * specified name and strength bonus.
     *
     * @param name the name of the shield
     * @param strengthBonus the strength bonus provided by the shield
     */
    public Shield(final String name, final int strengthBonus) {
        super(name, strengthBonus, 0);  // Strength only
    }
}