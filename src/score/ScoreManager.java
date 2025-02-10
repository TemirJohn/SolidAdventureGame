package score;

import combat.CombatManager;
import player.Player;

public class ScoreManager {
    private int score;
    private int killedEnemies;
    private int itemsCollected;
    private int levelsCompleted;
    private int highestLevel;
    private int totalExperienceGained;
    private int totalDamageTaken;
    private int totalHealing;

    public ScoreManager() {
        this.score = 0;
        this.killedEnemies = 0;
        this.itemsCollected = 0;
        this.levelsCompleted = 0;
        this.highestLevel = 1;
        this.totalExperienceGained = 0;
        this.totalDamageTaken = 0;
        this.totalHealing = 0;
    }

    public void addScore(int points) {
        score += points;
        checkAchievements();
    }

    public void addKilledEnemy() {
        killedEnemies++;
        addScore(10);
    }

    public void addItemCollected() {
        itemsCollected++;
        addScore(5);
    }

    public void addLevelCompleted() {
        levelsCompleted++;
        addScore(50);
    }

    public void updateHighestLevel(int currentLevel) {
        if (currentLevel > highestLevel) {
            highestLevel = currentLevel;
            addScore(100);
        }
    }

    public void addExperienceGained(int exp) {
        totalExperienceGained += exp;
    }

    public void addDamageTaken(int damage) {
        totalDamageTaken += damage;
    }

    public void addHealing(int healing) {
        totalHealing += healing;
    }

    public void showStatistics() {
        System.out.println("\n📊 Game Statistics:");
        System.out.println("🏆 Total Score: " + score);
        System.out.println("💀 Enemies Defeated: " + killedEnemies);
        System.out.println("🎒 Items Collected: " + itemsCollected);
        System.out.println("🌟 Levels Completed: " + levelsCompleted);
        System.out.println("📈 Highest Level Reached: " + highestLevel);
        System.out.println("⭐ Total Experience Gained: " + totalExperienceGained);
        System.out.println("💔 Total Damage Taken: " + totalDamageTaken);
        System.out.println("❤️ Total Healing Received: " + totalHealing);
        showAchievements();
    }

    private void checkAchievements() {
        if (!achievementKiller && killedEnemies >= 10) {
            unlockAchievement("Monster Hunter", "Defeat 10 enemies");
        }
        if (!achievementCollector && itemsCollected >= 15) {
            unlockAchievement("Master Collector", "Collect 15 items");
        }
        if (!achievementSurvivor && totalDamageTaken >= 1000) {
            unlockAchievement("Battle Hardened", "Take 1000 total damage");
        }
        if (!achievementHealer && totalHealing >= 500) {
            unlockAchievement("Recovery Master", "Heal for 500 total HP");
        }
        if (!achievementMaster && score >= 1000) {
            unlockAchievement("Game Master", "Reach 1000 total score");
        }
    }

    private boolean achievementKiller = false;
    private boolean achievementCollector = false;
    private boolean achievementSurvivor = false;
    private boolean achievementHealer = false;
    private boolean achievementMaster = false;

    private void unlockAchievement(String name, String description) {
        System.out.println("\n🏆 Achievement Unlocked!");
        System.out.println("\"" + name + "\" - " + description);
        addScore(25);
    }

    private void showAchievements() {
        System.out.println("\n🏆 Achievements:");
        showAchievement("Monster Hunter", "Defeat 10 enemies", achievementKiller);
        showAchievement("Master Collector", "Collect 15 items", achievementCollector);
        showAchievement("Battle Hardened", "Take 1000 total damage", achievementSurvivor);
        showAchievement("Recovery Master", "Heal for 500 total HP", achievementHealer);
        showAchievement("Game Master", "Reach 1000 total score", achievementMaster);
    }

    private void showAchievement(String name, String description, boolean unlocked) {
        String status = unlocked ? "✅" : "❌";
        System.out.println(status + " " + name + " - " + description);
    }


    public int getScore() {
        return score;
    }

    public int getKilledEnemies() {
        return killedEnemies;
    }

    public int getItemsCollected() {
        return itemsCollected;
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public int getTotalExperienceGained() {
        return totalExperienceGained;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public int getTotalHealing() {
        return totalHealing;
    }
}

