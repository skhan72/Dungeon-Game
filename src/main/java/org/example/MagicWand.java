package org.example;

/**
 * The {@code Wand} class represents a magical item
 * that enhances a character's craft attribute.
 * This item is for Wizards
 *
 */
public class MagicWand extends Item {
    /**
     * Constructs a new {@code Wand} with the specified name and craft bonus.
     *
     * @param name       the name of the wand
     * @param craftBonus the bonus to the craft attribute this wand provides
     */
    public MagicWand(final String name, final int craftBonus) {
        super(name, 0, craftBonus);  // Craft only
    }
}
