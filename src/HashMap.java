import java.util.ArrayList;

public class HashMap {
    private static final int DIVISOR = 907;
    private static final int R = 256;
    private static final int STARTING_LENGTH = 13;
    private int mapLength;
    private int numItems;
    private Item[] map;

    public HashMap() {
        this.numItems = 0;
        this.mapLength = STARTING_LENGTH;
        this.map = new Item[STARTING_LENGTH];
    }

    public void fillMap(Item item) {
        int hash = item.hash(mapLength);
        while (map[hash] != null) {
            hash = (hash+1)%mapLength;
            // If over half are full... resize
            if (numItems*1.0/mapLength > 0.5) {
                resize();
                hash = item.hash(mapLength);
            }
        }
        map[hash] = item;
        numItems++;
    }

    public void resize() {
        mapLength *= 2;
        Item[] out = new Item[mapLength];

        for (Item i : map) {
            if (i != null) {
                out[i.hash(mapLength)] = i;
            }
        }

        map = out;
    }
}
