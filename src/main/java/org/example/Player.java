package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Player} class represents the player's character in the dungeon game.
 * It extends the {@link Character} class and includes an inventory system for managing items.
 *
 */
public class Player extends Character {

    private List<Item> inventory;

    /**
     * Constructs a {@code Player} with the specified name, strength, craft, and health values
     * as listed in the instructions.
     *
     * @param name the player's name
     * @param strength the player's strength attribute
     * @param craft the player's craft attribute
     * @param health the player's initial health
     */
    public Player(String name, int strength, int craft, int health) {
        super(name, strength, craft, health);
        this.inventory = new ArrayList<>();
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        inventory.add(item);
    }

    /**
     * Removes an item from the player's inventory.
     *
     * @param item to remove
     */
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }
    /**
     * Returns the list of items currently in the player's inventory.
     *
     * @return a list of inventory items
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     *
     * @return a string describing the player
     */
    @Override
    public String toString() {
        return "Player: " + getName() + ", Health: " + getHealth();
    }

    /**
     *
     * @param item the item to pick up
     */
    public void pickUpItem(Item item) {
        inventory.add(item);
    }
}
