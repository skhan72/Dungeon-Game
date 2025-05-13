package org.example;
import javax.swing.*;
//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------

/**
 * The {@code Pick} class represents an action where the player picks up an item
 * from a chamber in the dungeon and adds it to their inventory.
 *
*/
public class Pick implements Action {


    private Player player;


    private Chamber chamber;


    private Item item;

    /**
     * Constructs a {@code Pick} action with the specified player, chamber, and item.
     *
     * @param player  the player who will pick up the item
     * @param chamber the chamber containing the item
     * @param item    the item that will be picked
     */
    public Pick(Player player, Chamber chamber, Item item) {
        this.player = player;
        this.chamber = chamber;
        this.item = item;
    }

    /**
     * Executes the pick action by adding the item to the player's inventory
     * and removing it from the chamber.
     */
    @Override
    public void execute() {
        player.addItem(item);
        chamber.removeItem(item);
        System.out.println("You picked up: " + item);
    }

    /**
     * Returns a string representation of the action for display in the UI.
     *
     * @return a description of the pick action
     */
    @Override
    public String toString() {
        return "Pick up " + item.getName();
    }
}
