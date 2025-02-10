package level;

import enemies.Enemy;
import items.Item;
import java.util.List;

public interface LevelFactory {
    List<Enemy> createEnemies();
    List<Item> createItems();
} 