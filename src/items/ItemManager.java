package items;

import player.Player;
import score.ScoreManager;
import level.LevelManager;

import java.util.List;

public class ItemManager implements IInventorySystem {
    private List<Item> items;
    private Player player;
    private ScoreManager score;
    private LevelManager levelManager;

    public ItemManager(List<Item> items, Player player, ScoreManager score, LevelManager levelManager) {
        this.items = items;
        this.player = player;
        this.score = score;
        this.levelManager = levelManager;
    }

    @Override
    public void pickUpItem(Item item) {
        if(!items.contains(item)) {
            System.out.println("⚠️ Error: " + item.getItemName() + " is not available.");
            return;
        }

        System.out.println("\n🎒 " + player.getName() + " picked up " + item.getItemName() + "!");

        item.itemEffect();

        int healthGained = item.getItemHP();
        if (healthGained > 0) {
            int newHealth = Math.min(
                    player.getHealth() + healthGained,
                    player.getPlayerMaxHealth()
            );
            player.setHealth(newHealth);
            System.out.println("❤️ Restored " + healthGained + " HP!");
        }

        int xpGained = item.getItemEXP();
        if (xpGained > 0) {
            player.setExperience(player.getExperience() + xpGained);
            System.out.println("⭐ Gained " + xpGained + " experience!");
        }

        System.out.println("\n📊 Item Results:");
        System.out.println("❤️ Health: " + player.getHealth() + "/" + player.getPlayerMaxHealth());
        System.out.println("📈 " + levelManager.getRequiredXPInfo(player));

        player.addItemToInventory(item);
        score.addScore(1);
        items.remove(item);

        /*showInventory();*/

        levelManager.checkAndHandleLevelUp(player);

        if (items.isEmpty()) {
            System.out.println("\n🎯 All items on this level have been collected!");
        }
    }

    @Override
    public void showAvailableItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        System.out.println("\n📦 Available items:");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getItemName() +
                    " (HP: +" + item.getItemHP() +
                    ", XP: +" + item.getItemEXP() + ")");
        }
    }

    /*public void showInventory() {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("🎒 Inventory is empty");
            return;
        }

        System.out.println("\n🎒 Current inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.println((i + 1) + ". " + item.getItemName());
        }
    }*/

    @Override
    public void addItem(Item item) {
        items.add(item);
        System.out.println("✨ New item appeared: " + item.getItemName());
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public void useItem(Item item, Player player) {
        if (!items.contains(item)) {
            return;
        }
        
        item.itemEffect();
        applyItemEffects(item, player);
        removeItem(item);
    }

    @Override
    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    @Override
    public boolean hasItems() {
        return !items.isEmpty();
    }

    private void applyItemEffects(Item item, Player player) {
        // ... логика применения эффектов предмета ...
    }
}
