package items;

import player.Player;

public class HealthElixir extends Item {
    public void use(Player player) {
        int healAmount = 20;
        player.restoreHealth(healAmount);
        System.out.println("Player used a Health Elixir and restored " + healAmount + " HP!");
    }
    public HealthElixir() {
        super("Health Elixir", 0, 20);
    }

    @Override
    public void itemEffect() {
        System.out.println("Tastes like cough syrup...");
    }
}
