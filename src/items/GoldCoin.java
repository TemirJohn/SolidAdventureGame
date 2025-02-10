package items;

import player.Player;

public class GoldCoin extends Item {
    public GoldCoin() {
        super("Gold coin", 10, 0);
    }

    @Override
    public void itemEffect() {
        System.out.println("We need more gold!");
    }}

