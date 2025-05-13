package org.example;
/**
 * The {@code Warrior} class represents a
 * specialized type of {@link Character}
 *
 */
public class Warrior extends Character {
    /**
     * Constructs a new {@code Warrior}
     * with the specified name, health, strength,
     * and craft.
     *
     * @param name     the name of the warrior
     * @param health   the initial health points of the warrior
     * @param strength the strength attribute of the warrior
     * @param craft    the craft (intelligence or magic)
     *                 attributes of the warrior
     */
    public Warrior(final String name, final int health,
                   final int strength,
                   final int craft) {
        super(name, health, strength, craft);
    }
}