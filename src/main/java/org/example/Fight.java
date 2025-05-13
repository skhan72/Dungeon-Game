//-----------------------------
//Written By: Summaiya Khan - 2080068
// For SE350 Online synch section - Spring 2025
//-----------------------------
package org.example;
/**
 * The Fight class represents an action where the player fights with a monster.
 */
public class Fight implements Action {
    private Player player;
    private Monster monster;

    /**
     * Constructs a Fight action with the specified player and monster.
     *
     * @param player the player character involved in the fight
     * @param monster the monster that the player will fight
     */
    public Fight(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void execute() {
        System.out.println("You have encountered " + monster.getName() + "!");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            // Player's turn to attack
            int playerDamage = player.getStrength(); // Simplified for now; can include craft for magic
            monster.takeDamage(playerDamage);
            System.out.println("You gave " + playerDamage + " damage to the " + monster.getName());
            System.out.println(monster.getName() + " has " + monster.getHealth() + " health left.");

            if (monster.getHealth() <= 0) {
                System.out.println("You defeated the " + monster.getName() + "!");
                break;
            }

            // Monster's turn to attack
            int monsterDamage = monster.getStrength(); // Monster's attack damage
            player.takeDamage(monsterDamage);
            System.out.println(monster.getName() + " dealt " + monsterDamage + " damage to you.");
            System.out.println("You have " + player.getHealth() + " health left.");

            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated by the "
                        + monster.getName() + "!");
                break;
            }
        }
    }

    /**
     *
     * @return a description of the action (i.e., fighting a monster)
     */
    @Override
    public String toString() {
        return "Fight " + monster.getName();
    }
}
