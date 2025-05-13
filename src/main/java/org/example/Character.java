package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a character in the game.
 * It has all the attributes of the character like health
 */
public abstract class Character {
    /**
     * The name of the character.
     */
    protected String name;
    /**
     * The health of the character.
     */
    protected int health;
    protected int strength;
    protected int craft;
    protected List<Item> inventory;
    protected Item leftHand;
    protected Item rightHand;

    /**
     * Creates a new character with the name, health, strength, and craft.
     *
     * @param name The name of the character.
     * @param health The health of the character.
     * @param strength The strength of the character.
     * @param craft The craft of the character.
     */
    public Character(String name, int health, int strength, int craft) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.craft = craft;
        this.inventory = new ArrayList<>();
    }

    /**
     * Adds an item to the character's inventory.
     *
     */
    public void pickItem(Item item) {
        inventory.add(item);
    }

    /**
     * Equips an item to either the left or right hand of the character.
     *
     */
    public void equipItem(Item item, boolean right) {
        if (inventory.contains(item)) {
            if (right) rightHand = item;
            else leftHand = item;
        }
    }

    /**
     * returns the strength of the character
     */
    public int getEffectiveStrength() {
        int bonus = 0;
        if (leftHand != null) bonus += leftHand.getStrength();
        if (rightHand != null) bonus += rightHand.getStrength();
        return strength + bonus;
    }

    /**
     * @return The effective craft of the character.
     */
    public int getEffectiveCraft() {
        int bonus = 0;
        if (leftHand != null) bonus += leftHand.getCraft();
        if (rightHand != null) bonus += rightHand.getCraft();
        return craft + bonus;
    }

    /**
     * Checks if the character is still alive or dead (health <= 0).
     *
     * @return True if the character is dead, false otherwise.
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Takes damage and reduces the character's health.
     *
     */
    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) health = 0;
    }

    /**
     * Returns the current health of the character.
     *
     */
    public int getHealth() { return health; }

    /**
     * Returns the name of the character.
     *
     */
    public String getName() { return name; }
}

