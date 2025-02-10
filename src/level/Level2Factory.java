package level;

import enemies.*;
import items.*;
import java.util.ArrayList;
import java.util.List;

public class Level2Factory implements LevelFactory {
    @Override
    public List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Vampire());
        return enemies;
    }

    @Override
    public List<Item> createItems() {
        List<Item> items = new ArrayList<>();
        items.add(new MagicScroll());
        return items;
    }
} 