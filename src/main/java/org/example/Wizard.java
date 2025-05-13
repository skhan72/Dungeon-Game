//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------
package org.example;
/**
 * The {@code Wizard} class represents a
 * specialized type of {@link Character}
 *
 */
public class Wizard extends Character {
    /**
     * The maximum level a Wizard can achieve.
     */
    private static final int MAX_LEVEL = 10;
    /**
     * The start health value for a Wizard.
     */
    private static final int BASE_HEALTH = 100;

    /**
     * @param name the name of the wizard
     *
     */
    public Wizard(final String name) {
        super(name, 2, MAX_LEVEL, BASE_HEALTH);
    }
}