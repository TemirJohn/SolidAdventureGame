package level;

import enemies.*;
import items.*;
import java.util.ArrayList;
import java.util.List;

public class Level1Factory implements LevelFactory {
    @Override
    public List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Zombie());
        enemies.add(new Zombie());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());

        return enemies;
    }

    @Override
    public List<Item> createItems() {
        List<Item> items = new ArrayList<>();
        items.add(new GoldCoin());
        items.add(new HealthElixir());
        items.add(new HealthElixir());
        return items;
    }
} 