//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------
package org.example;
/**
 * The {@code Monster} class represents a monster in the dungeon game.
 * Each monster has a name, strength, craft, and health, which determine
 * its fighting abilities and interactions with the player.
 *
 */
public class Monster {

    /** The name of the monster. */
    private String name;

    /** The strength of the monster. */
    private int strength;

    /** The craft (intelligence) of the monster. */
    private int craft;

    /** The current health of the monster. */
    private int health;

    /**
     * Constructs a {@code Monster} with the specified attributes.
     *
     * @param name    the name of the monster
     * @param strength the strength of the monster
     * @param craft   the craft (intelligence) of the monster
     * @param health  the initial health of the monster
     */
    public Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    /**
     *
     * @return the current health of the monster
     */
    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0; // Ensure health doesn't go negative
    }
    /**
     *
     * @return the name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the strength of the monster
     */
    public int getStrength() {
        return strength;
    }

    /**
     *
     * @return the craft of the monster
     */
    public int getCraft() {
        return craft;
    }

    /**
     * Reduces the monster's health by a specified amount. If the health
     * drops below zero, it is set to zero.
     *
     * @param amount the amount of health to reduce
     */
    public void reduceHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
