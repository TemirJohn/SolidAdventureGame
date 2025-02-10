package items;

import player.Player;

public interface IInventorySystem {
    void addItem(Item item);
    void removeItem(Item item);
    void useItem(Item item, Player player);
    boolean hasItem(Item item);
    boolean hasItems();
    void pickUpItem(Item item);
    void showAvailableItems();
} 