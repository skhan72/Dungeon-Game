package org.example;
 /**
  * The Door class represents a door between two chambers in the dungeon.
  */
public class Door {
    private Chamber chamber1;
    private Chamber chamber2;
    private Monster monster;

    /**
     * Creates a door between two chambers and optionally associates a monster with the door.
     *
     * @param chamber1 The first chamber connected by the door.
     * @param chamber2 The second chamber connected by the door.
     * @param monster The monster guarding the door, or null if the door is unguarded.
     */
    public Door(Chamber chamber1, Chamber chamber2, Monster monster) {
        this.chamber1 = chamber1;
        this.chamber2 = chamber2;
        this.monster = monster;
    }


    public Chamber getOtherChamber(Chamber from) {
        if (from.equals(chamber1)) {
            return chamber2;
        } else if (from.equals(chamber2)) {
            return chamber1;
        } else {
            return null;
        }
    }

    public boolean hasMonster() {
        return monster != null && monster.getHealth() > 0;
    }

    /**
     * Returns the monster guarding the door, if there is one.
     *
     * @return The Monster object guarding the door, or null if the door is unguarded.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Checks if the door is currently guarded by a monster.
     *
     * @return True if the door is guarded, false otherwise.
     */
    public boolean isGuarded() {
        return monster != null && monster.getHealth() > 0;
    }

    public void removeMonster() {
        this.monster = null;
    }
}

