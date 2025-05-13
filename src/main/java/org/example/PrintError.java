//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------
package org.example;

/**
 * The {@code PrintError} class represents an action that handles errors during user interaction.
 * It implements the {@link Action} interface and is used to display error messages
 * without terminating the game.
 */
public class PrintError implements Action {

    private Dungeon dungeon;

    private Exception exception;

    /**
     * Constructs a {@code PrintError} action with the specified dungeon and exception.
     *
     * @param dungeon the current dungeon instance
     * @param exception the exception that occurred
     */
    public PrintError(final Dungeon dungeon, final Exception exception) {
        this.dungeon = dungeon;
        this.exception = exception;
    }

    /**
     * prints the error message
     */
    @Override
    public void execute() {
        System.out.println("Error: " + exception.getMessage());
    }

    /**
     * Returns a string representation of the
     * error action for display in the UI.
     *
     * @return a user-friendly error message
     */
    @Override
    public String toString() {
        return "Invalid input. Please try again.";
    }
}
