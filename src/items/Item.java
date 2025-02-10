package items;

import player.Player;

public abstract class Item {
    private String itemName;
    private int itemEXP;
    private int itemHP;

    public Item(String itemName, int itemEXP, int itemHP) {
        this.itemName = itemName;
        this.itemEXP = itemEXP;
        this.itemHP = itemHP;
    }


    public String getItemName() {
        return itemName;
    }

    public int getItemEXP() {
        return itemEXP;
    }

    public int getItemHP() {
        return itemHP;
    }

    public abstract void itemEffect();

    @Override
    public String toString() {
        return itemName;
    }
}

