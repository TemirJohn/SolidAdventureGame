package player;


import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int experience;
    private List<String> inventory;
    private List<Item> items;
    private int playerLevel;
    private int playerMaxHealth;
    private int PlayerDMG;

    public Player(String name, int health, int experience) {
        this.name = name;
        this.health = health;
        this.experience = experience;
        this.inventory = new ArrayList<>();
        this.items = new ArrayList<>();
        this.playerLevel = 1;
        this.PlayerDMG = 20;
        this.playerMaxHealth = health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void restoreHealth(int amount) {
        this.health += amount;
        if (this.health > playerMaxHealth) {
            this.health = playerMaxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public void addItemToInventory(Item item) {
        inventory.add(String.valueOf(item));
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public int getPlayerDMG() {
        return PlayerDMG;
    }

    public void setPlayerDMG(int playerDMG) {
        PlayerDMG = playerDMG;
    }
}
