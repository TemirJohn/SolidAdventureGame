package enemies;

public class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 50, 10, 20);
    }

    public void attack() {
        System.out.println(getEnemyName() + " shoots an arrow!");
    }
}
