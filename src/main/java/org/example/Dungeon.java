package org.example;

import java.util.*;

/**
 * The Dungeon class represents the entire dungeon game.
 *
 */
public class Dungeon {
    private Chamber currentChamber;
    private Chamber endChamber;
    private List<Chamber> chambers = new ArrayList<>();
    private Player player;

    /**
     * Initializes a new dungeon with a player and sets up the dungeon chambers, doors,
     * and items.
     *
     * @param player The player object representing the player in the game.
     */
    public Dungeon(Player player) {
        this.player = player;
        setupDungeon();
    }

    /**
     * Sets up the dungeon by creating and connecting chambers, doors, and items.
     */
    private void setupDungeon() {
        // Create chambers
        Chamber start = new Chamber("Start");
        Chamber interval = new Chamber("Interval");
        Chamber end = new Chamber("End");

        // Add doors (undirected)
        Door door1 = new Door(start, interval, new Monster("Goblin", 5, 0, 10)); // Strength-based
        Door door2 = new Door(interval, end, new Monster("Spider", 0, 5, 10)); // Craft-based

        start.addDoor(door1);
        interval.addDoor(door1);
        interval.addDoor(door2);
        end.addDoor(door2);

        // Add items to chambers
        start.addItem(new Sword("Iron Sword", 3));
        interval.addItem(new MagicWand("Magic Wand", 4));

        chambers.add(start);
        chambers.add(interval);
        chambers.add(end);

        this.currentChamber = start;
        this.endChamber = end;
    }

    /**
     * @return True if the player is in the last chamber, false otherwise.
     */
    public boolean hasEnded() {
        return currentChamber == endChamber;
    }

    /**
     *
     * @return The current Chamber object.
     */
    public Chamber getCurrentChamber() {
        return currentChamber;
    }

    /**
     *
     * @param chamber The new Chamber object representing the player's location.
     */
    public void setCurrentChamber(Chamber chamber) {
        this.currentChamber = chamber;
    }

    /**
     * Returns the player object representing the player in the game.
     *
     */
    public Character getPlayer() {
        return player;
    }

    /**
     *
     * @return A list of Action objects representing the possible actions.
     */
    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();

        for (Item item : currentChamber.getItems()) {
            actions.add(new Pick(player, currentChamber, item));
        }

        for (Door door : currentChamber.getDoors()) {
            if (door.hasMonster()) {
                actions.add(new Fight(player, door.getMonster()));
            } else {
                actions.add(new Move(this, door.getOtherChamber(currentChamber)));
            }
        }

        return actions;
    }
}



