package enemies;

import player.Player;

public class Zombie extends Enemy {
    public Zombie() {
        super("Zombie", 100, 15, 30);
    }

    @Override
    public void attack() {
        System.out.println(getEnemyName() + " bites fiercely!");
    }
}
