package game;

import player.Player;
import level.LevelManager;

public class GameState implements IGameState {
    private Player player;
    private LevelManager levelManager;
    private boolean isGameRunning;

    public GameState(Player player, LevelManager levelManager) {
        this.player = player;
        this.levelManager = levelManager;
        this.isGameRunning = true;
    }

    @Override
    public void updateState() {
        if (player.getHealth() <= 0 || levelManager.getCurrentLevel() > 3) {
            isGameRunning = false;
        }
    }

    @Override
    public boolean isGameOver() {
        return !isGameRunning;
    }

    @Override
    public String getGameOverMessage() {
        if (player.getHealth() <= 0) {
            return "You have been defeated! 💀";
        } else if (levelManager.getCurrentLevel() > 3) {
            return "Congratulations! You have completed all levels! 🎉";
        }
        return "";
    }
} 