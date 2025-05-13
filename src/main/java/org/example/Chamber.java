package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chamber in the dungeon. A chamber can contain items and doors
 * that lead to other chambers.
 */
public class Chamber {

        private String name;

        private List<Item> items;
        /**
         * List of doors in the chamber.
         */
        private List<Door> doors;

        /**
         * Constructs a new Chamber with the specified name.
         *
         * @param name The name of the chamber.
         */
        public Chamber(String name) {
            this.name = name;
            this.items = new ArrayList<>();
            this.doors = new ArrayList<>();
        }

        /**
         * Adds an item to the chamber.
         *
         * @param item The item to add to the chamber.
         */
        public void addItem(Item item) {
            items.add(item);
        }

        /**
         * Adds a door to the chamber that leads to another chamber.
         *
         * @param door The door to add to the chamber.
         */
        public void addDoor(Door door) {
            doors.add(door);
        }

        /**
         * Removes an item from the chamber.
         *
         * @param item The item to remove from the chamber.
         */
        public void removeItem(Item item) {
            items.remove(item); // Remove item from the chamber's items list
        }

        /**
         * Returns the list of items in the chamber.
         *
         * @return A list of Item objects present in the chamber.
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         * Returns the list of doors in the chamber.
         *
         * @return A list of Door objects present in the chamber.
         */
        public List<Door> getDoors() {
            return doors;
        }

        /**
         * Returns the name of the chamber.
         *
         * @return The name of the chamber.
         */
        public String getName() {
            return name;
        }
    }
