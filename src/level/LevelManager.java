package level;

import items.GoldCoin;
import items.HealthElixir;
import items.Item;
import items.MagicScroll;
import enemies.Enemy;
import enemies.Skeleton;
import enemies.Vampire;
import enemies.Zombie;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LevelManager {
    private int currentLevel;
    private List<Enemy> enemies;
    private List<Item> items;
    private final Map<Integer, LevelFactory> levelFactories;

    private static final int BASE_XP_FOR_LEVEL = 100;
    private static final double LEVEL_MULTIPLIER = 1.5;

    public LevelManager() {
        this.currentLevel = 1;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.levelFactories = new HashMap<>();
        initializeLevelFactories();
    }

    private void initializeLevelFactories() {
        levelFactories.put(1, new Level1Factory());
        levelFactories.put(2, new Level2Factory());
        levelFactories.put(3, new Level3Factory());
    }

    public void advanceLevel(){
        currentLevel++;
        System.out.println("Advancing to level " + currentLevel + "...");
        initLevel();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }

    public void initLevel(){
        enemies.clear();
        items.clear();
        
        LevelFactory factory = levelFactories.get(currentLevel);
        if (factory != null) {
            enemies.addAll(factory.createEnemies());
            items.addAll(factory.createItems());
        } else {
            System.out.println("No more levels. Game complete!");
        }
    }

    public void checkAndHandleLevelUp(Player player) {
        int currentXP = player.getExperience();
        int playerLevel = player.getPlayerLevel();
        int requiredXP = calculateRequiredXP(playerLevel);

        if (currentXP >= requiredXP) {
            playerLevel++;
            player.setPlayerLevel(playerLevel);

            applyLevelUpBonuses(player);

            System.out.println("🎉 LEVEL UP! " + player.getName() +
                    " reached level " + playerLevel + "!");

            if (playerLevel % 2 == 0 && currentLevel < 3) {
                advanceLevel();
            }
        }
    }

    private int calculateRequiredXP(int level) {
        return (int)(BASE_XP_FOR_LEVEL * (level * LEVEL_MULTIPLIER));
    }

    private void applyLevelUpBonuses(Player player) {

        int newMaxHealth = player.getPlayerMaxHealth() + 20;
        player.setPlayerMaxHealth(newMaxHealth);

        player.setHealth(newMaxHealth);

        player.setPlayerDMG(player.getPlayerDMG() + 5);

        System.out.println("💪 Level up bonuses:");
        System.out.println("❤️ Max Health increased to: " + newMaxHealth);
        System.out.println("💕 Health fully restored");
        System.out.println("⚔️ Damage increased to: " + player.getPlayerDMG());
    }

    public String getRequiredXPInfo(Player player) {
        int currentXP = player.getExperience();
        int requiredXP = calculateRequiredXP(player.getPlayerLevel());
        return "XP: " + currentXP + "/" + requiredXP;
    }
}
