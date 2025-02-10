import items.*;
import combat.CombatManager;
import enemies.Enemy;
import level.LevelManager;
import player.Player;
import score.ScoreManager;

import java.util.Scanner;

public class GameEngine {
    private Player player;
    private LevelManager levelManager;
    private CombatManager combatManager;
    private ItemManager itemManager;
    private ScoreManager scoreManager;
    private Scanner scanner;
    private boolean isGameRunning;

    public GameEngine() {
        scanner = new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        System.out.println("🎮 Welcome to the Adventure Game!");
        System.out.print("Enter your hero's name: ");
        String playerName = scanner.nextLine();

        player = new Player(playerName, 100, 20);
        scoreManager = new ScoreManager();
        levelManager = new LevelManager();
        levelManager.initLevel();
        combatManager = new CombatManager(levelManager.getEnemies(), player, scoreManager, levelManager);
        itemManager = new ItemManager(levelManager.getItems(), player, scoreManager, levelManager);

        isGameRunning = true;
    }

    public void runGame() {
        while (isGameRunning) {
            showGameStatus();
            showMainMenu();
            processUserInput();

            if (player.getHealth() <= 0) {
                gameOver("You have been defeated! 💀");
            } else if (levelManager.getCurrentLevel() > 3) {
                gameOver("Congratulations! You have completed all levels! 🎉");
            }
        }
    }

    private void showGameStatus() {
        System.out.println("\n========================================");
        System.out.println("📊 Game Status:");
        System.out.println("👤 " + player.getName() +
                " (Level " + player.getPlayerLevel() + ")");
        System.out.println("❤️ Health: " + player.getHealth() +
                "/" + player.getPlayerMaxHealth());
        System.out.println("⚔️ Attack: " + player.getPlayerDMG());
        System.out.println("📈 " + levelManager.getRequiredXPInfo(player));
        System.out.println("🌟 Current Level: " + levelManager.getCurrentLevel());
        System.out.println("🏆 Score: " + scoreManager.getScore());
        System.out.println("========================================");
    }

    private void showMainMenu() {
        System.out.println("\n🎮 Available Actions:");
        System.out.println("1. 👊 Fight Enemies");
        System.out.println("2. 🎒 Manage Items");
        System.out.println("3. 📊 Show Statistics");
        System.out.println("4. ❌ Exit Game");
        System.out.print("Choose your action (1-4): ");
    }

    private void processUserInput() {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                handleCombat();
                break;
            case 2:
                handleItems();
                break;
            case 3:
                scoreManager.showStatistics();
                break;
            case 4:
                isGameRunning = false;
                System.out.println("Thanks for playing! 👋");
                break;
            default:
                System.out.println("⚠️ Invalid choice! Please try again.");
        }
    }

    private void handleCombat() {
        if (!combatManager.hasEnemies()) {
            System.out.println("No enemies available on this level!");
            return;
        }

        combatManager.showEnemies();
        System.out.print("Choose enemy to fight (1-" +
                levelManager.getEnemies().size() + ") or 0 to cancel: ");

        int choice = scanner.nextInt();
        if (choice > 0 && choice <= levelManager.getEnemies().size()) {
            Enemy enemy = levelManager.getEnemies().get(choice - 1);
            combatManager.fightEnemy(enemy);
        }
    }

    private void handleItems() {
        if (!itemManager.hasItems()) {
            System.out.println("No items available on this level!");
            return;
        }

        itemManager.showAvailableItems();
        System.out.print("Choose item to pick up (1-" +
                levelManager.getItems().size() + ") or 0 to cancel: ");

        int choice = scanner.nextInt();
        if (choice > 0 && choice <= levelManager.getItems().size()) {
            Item item = levelManager.getItems().get(choice - 1);
            itemManager.pickUpItem(item);
        }
    }

    private void gameOver(String message) {
        System.out.println("\n" + message);
        scoreManager.showStatistics();
        isGameRunning = false;
    }
}