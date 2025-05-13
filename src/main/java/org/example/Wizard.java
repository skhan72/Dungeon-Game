package org.example;

public class Wizard extends Character {
    /**
     * The maximum level a Wizard can achieve.
     */
    private static final int MAX_LEVEL = 10;
    /**
     * The start health value for a Wizard.
     */
    private static final int BASE_HEALTH = 100;


    public Wizard(final String name) {
        super(name, 2, MAX_LEVEL, BASE_HEALTH);
    }
}