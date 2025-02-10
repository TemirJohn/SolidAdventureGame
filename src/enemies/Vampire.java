package enemies;

import player.Player;

public class Vampire extends Enemy {
    public Vampire() {
        super("Vampire", 80, 25, 50);
    }

    public void attack() {
        System.out.println(getEnemyName() + " drains your blood!");
    }
}
