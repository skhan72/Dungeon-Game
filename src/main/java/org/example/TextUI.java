package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code TextUI} class handles the user interface
 * interactions for the dungeon game.
 */
public class TextUI {
    /**
     * Begins the game loop and handles the main
     * progression until the dungeon is finished.
     *
     * @param d the {@link Dungeon} object representing the game world
     */
    public void play(final Dungeon d) {
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }
        System.out.println("Congratulations! You finished the dungeon.");
    }

    /**
     * Prints the current state of the chamber, including the number of doors,
     * items, and any monsters guarding doors.
     *
     * @param d the {@link Dungeon} object to extract the current chamber from
     */
    private void print(final Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("You are in a chamber with " + r.getDoors().size()
                + " doors\n");
        s.append("There are " + r.getItems().size()
                + " items in the chamber\n");

        for (Door door : r.getDoors()) {
            Monster m = door.getMonster();
            if (m != null && m.getHealth() > 0) {
                s.append("Door to '").append(door.getOtherChamber(r).getName())
                        .append("' is guarded by ").append(m.getName())
                        .append(" (Strength: ").append(m.getStrength())
                        .append(", Craft: ").append(m.getCraft())
                        .append(", Health: ")
                        .append(m.getHealth()).append(")\n");
            } else {
                s.append("Door to '").append(door.getOtherChamber(r).getName())
                        .append("' is unguarded.\n");
            }
        }

        System.out.println(s.toString());
    }

    /**
     *
     * @param actions the list of {@link Action} objects the player can take
     * @return the index of the chosen action
     */
    public int getPlayerChoice(final List<Action> actions) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do?");

        // Display actions
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((i + 1) + ". " + actions.get(i).toString());
        }

        // Get player's choice
        System.out.print("Enter your choice (1-" + actions.size() + "): ");
        int choice = scanner.nextInt() - 1;

        if (choice >= 0 && choice < actions.size()) {
            return choice;
        } else {
            System.out.println("Invalid choice. Please try again.");
            return getPlayerChoice(actions); // Retry if invalid input
        }
    }

    /**
     * Displays the current chamber's name, items, and available doors.
     *
     * @param dungeon the current {@link Dungeon} instance
     */
    public void displayDungeon(final Dungeon dungeon) {
        Chamber currentChamber = dungeon.getCurrentChamber();
        System.out.println("You are in the " + currentChamber.getName()
                + " chamber.");

        // Display items in the current chamber
        if (!currentChamber.getItems().isEmpty()) {
            System.out.println("Items in this chamber:");
            for (Item item : currentChamber.getItems()) {
                System.out.println("- " + item.getName());
            }
        } else {
            System.out.println("There are no items in this chamber.");
        }

        // Display available doors
        System.out.println("Doors:");
        for (Door door : currentChamber.getDoors()) {
            Chamber otherChamber = door.getOtherChamber(currentChamber);
            System.out.println("- " + otherChamber.getName());
        }

        // Display monsters guarding doors, if any
        for (Door door : currentChamber.getDoors()) {
            Monster monster = door.getMonster();
            if (monster != null && monster.getHealth() > 0) {
                System.out.println("Monster guarding door: " + monster.getName());
            }
        }
    }

    public void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice, please try again.");
    }

    public void displayVictory() {
        System.out.println("Congratulations! You have reached the end chamber and won the game!");
    }


    /**
     * Asks the player which action to perform
     * by displaying all available actions and reading input.
     *
     * @param d the current {@link Dungeon} instance
     * @return the {@link Action} selected by the player
     */
    private Action ask(final Dungeon d) {
        List<Action> actions = d.getActions();

        // Add a fight action if there's a monster in the room
        Chamber currentChamber = d.getCurrentChamber();
        for (Door door : currentChamber.getDoors()) {
            Monster monster = door.getMonster();
            if (monster != null && monster.getHealth() > 0) {
                actions.add(new Fight((Player) d.getPlayer(), monster));

            }
        }

        // Present the options to the player
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append("\t" + i + ": " + a.toString() + "\n");
        }
        System.out.println(s.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid input. Try again.");
            return new PrintError(d, e);
        }
    }
}