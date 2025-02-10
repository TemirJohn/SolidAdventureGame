package game;

public interface IGameState {
    void updateState();
    boolean isGameOver();
    String getGameOverMessage();
} 