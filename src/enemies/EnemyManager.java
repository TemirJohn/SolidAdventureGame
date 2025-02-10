package enemies;

import java.util.Random;

public class EnemyManager {
    


    public Enemy spawnEnemy() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new Skeleton();
        } else {
            return new Vampire();
        }
    }
}
