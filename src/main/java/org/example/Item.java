package org.example;

/**
 * Represents an item that a character can carry in the dungeon game.
 * Items can provide bonuses to a character's strength and craft.
 *
 */
public abstract class Item {

    /** The name of the item. */
    protected String name;

    /** The bonus to strength provided by the item. */
    protected int strengthBonus;

    /** The bonus to craft (intelligence) provided by the item. */
    protected int craftBonus;

    /**
     * Constructs an item with the specified name, strength bonus, and craft bonus.
     *
     * @param name        the name of the item
     * @param strengthBonus the bonus to strength provided by the item
     * @param craftBonus   the bonus to craft provided by the item
     */
    public Item(String name, int strengthBonus, int craftBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.craftBonus = craftBonus;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the strength bonus provided by the item.
     *
     * @return the strength bonus of the item
     */
    public int getStrength() {
        return strengthBonus;
    }

    /**
     * Gets the craft bonus provided by the item.
     *
     * @return the craft bonus of the item
     */
    public int getCraft() {
        return craftBonus;
    }

    /**
     * Returns a string representation of the item, including its name, strength bonus,
     * and craft bonus.
     *
     * @return a string representation of the item
     */
    @Override
    public String toString() {
        return name + " (STR: +" + strengthBonus + ", CRFT: +" + craftBonus + ")";
    }
}
