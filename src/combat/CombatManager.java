package combat;

import enemies.Enemy;
import player.Player;
import score.ScoreManager;
import level.LevelManager;

import java.util.List;

public class CombatManager {
    private List<Enemy> enemies;
    private Player player;
    private ScoreManager score;
    private LevelManager levelManager;

    public CombatManager(List<Enemy> enemies, Player player, ScoreManager score, LevelManager levelManager) {
        this.enemies = enemies;
        this.player = player;
        this.score = score;
        this.levelManager = levelManager;
    }

    public void fightEnemy(Enemy enemy) {
        if(!enemies.contains(enemy)) {
            System.out.println("⚠️ Error: " + enemy.getEnemyName() + " is not in the enemy list.");
            return;
        }

        System.out.println("\n⚔️ " + player.getName() + " engages in combat with " + enemy.getEnemyName() + "!");

        enemy.attack();
        int damageTaken = enemy.getEnemyDMG();
        player.setHealth(player.getHealth() - damageTaken);
        System.out.println("💥 You took " + damageTaken + " damage!");

        if (player.getHealth() <= 0) {
            System.out.println("💀 You have been defeated!");
            return;
        }

        int xpGained = enemy.getEnemyXP();
        player.setExperience(player.getExperience() + xpGained);
        score.addKilledEnemy();
        score.addScore(2);

        System.out.println("\n📊 Combat Results:");
        System.out.println("❤️ Health: " + player.getHealth() + "/" + player.getPlayerMaxHealth());
        System.out.println("⭐ Experience gained: " + xpGained);
        System.out.println("📈 " + levelManager.getRequiredXPInfo(player));

        levelManager.checkAndHandleLevelUp(player);

        enemies.remove(enemy);

        if (enemies.isEmpty()) {
            System.out.println("\n🎯 All enemies on this level have been defeated!");
        }
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        System.out.println("👾 " + enemy.getEnemyName() + " has appeared!");
    }

    public boolean hasEnemies() {
        return !enemies.isEmpty();
    }

    public void showEnemies() {
        if (enemies.isEmpty()) {
            System.out.println("No enemies present.");
            return;
        }

        System.out.println("\n👾 Current enemies:");
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            System.out.println((i + 1) + ". " + enemy.getEnemyName() +
                    " (HP: " + enemy.getEnemyHP() +
                    ", DMG: " + enemy.getEnemyDMG() +
                    ", XP: " + enemy.getEnemyXP() + ")");
        }
    }
}
