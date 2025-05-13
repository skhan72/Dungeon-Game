package org.example;

/**
 * The {@code Move} class represents an action where the player moves from one chamber
 * to another within the dungeon.
 *
 * <p>This action updates the player's current location in the dungeon by setting the
 * target chamber as the new current chamber.</p>
 *
 * Example usage:
 * <pre>
 *     Move moveAction = new Move(dungeon, targetChamber);
 *     moveAction.execute();
 * </pre>
 *
 * @author
 */
public class Move implements Action {

    /** The dungeon in which the player is moving. */
    private Dungeon dungeon;

    /** The target chamber the player is moving to. */
    private Chamber target;

    /**
     * Constructs a {@code Move} action with the specified dungeon and target chamber.
     *
     * @param dungeon the dungeon the player is moving in
     * @param target  the target chamber to move to
     */
    public Move(Dungeon dungeon, Chamber target) {
        this.dungeon = dungeon;
        this.target = target;
    }

    /**
     * Executes the move action by updating the current chamber in the dungeon.
     */
    @Override
    public void execute() {
        dungeon.setCurrentChamber(target);
    }

    /**
     * Returns a string representation of the move action for display in the UI.
     *
     * @return a description of the move action
     */
    @Override
    public String toString() {
        return "Move to " + target.getName();
    }
}
