package org.example;
import java.util.List;

/**
 * The Game class serves as the entry point for running the dungeon game.
 * It initializes the player, dungeon, and user interface, then runs the game loop
 * until the dungeon is finished.
 *
 */
public class Game {

    /**
     * The main method initializes and starts the dungeon game.
     * It creates a player, sets up the dungeon, and runs the game loop.
     *
     */
    public static void main(String[] args) {
        // Create the player character
        Player player = new Player("Summaiya", 10, 5, 2);  // Or you can switch to Wizard

        // Initialize the dungeon with the player
        Dungeon dungeon = new Dungeon(player);

        // Create the TextUI instance
        TextUI ui = new TextUI();

        // Start the game loop
        while (!dungeon.hasEnded()) {
            // Display the current state of the dungeon
            ui.displayDungeon(dungeon);

            // Get available actions based on the current state of the dungeon
            List<Action> actions = dungeon.getActions();

            // Get the player's choice of action
            int choice = ui.getPlayerChoice(actions);

            while (choice < 0 || choice >= actions.size()) {
                ui.displayInvalidChoiceMessage();  // Assuming TextUI has a method for invalid choice
                choice = ui.getPlayerChoice(actions);
            }

            actions.get(choice).execute();
        }

        // Once the game is finished, display the victory message
        ui.displayVictory();
    }
}

