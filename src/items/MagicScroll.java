package items;

import player.Player;

public class MagicScroll extends Item {
    public MagicScroll() {
        super("Magic Scroll", 20, 0);
    }

    @Override
    public void itemEffect() {
        System.out.println("The scroll is open… but there’s nothing written on it!");
    }
}
