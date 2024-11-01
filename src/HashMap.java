public class HashMap {
    private static final int DIVISOR = 907;
    private static final int R = 256;
    private static final String INVALID = "INVALID KEY";
    private static final int STARTING_LENGTH = 25;
    private int mapLength;
    private int numItems;
    private Item[] map;

    public HashMap() {
        this.numItems = 0;
        this.mapLength = STARTING_LENGTH;
        this.map = new Item[STARTING_LENGTH];
    }

    public void addItem(Item item) {
        int hash = item.hash(mapLength);
        while (map[hash] != null) {
            hash = (hash+1)%mapLength;
            // If over half are full resize
            if (numItems*1.0/mapLength > 0.5) {
                resize();
                hash = item.hash(mapLength);
            }
        }
        map[hash] = item;
        numItems++;
    }

    public void addItem(Item[] itemMap, Item item) {
        int hash = item.hash(mapLength);
        while (itemMap[hash] != null) {
            hash = (hash+1)%mapLength;
            // If over half are full resize
//            if (numItems*1.0/mapLength > 0.5) {
//                resize();
//                hash = item.hash(mapLength);
//            }
        }
        itemMap[hash] = item;
        numItems++;
    }

    public Item[] getMap() {
        return map;
    }

    public int hash(String word) {
        int out = 0;
        for (int i = 0; i < word.length(); i++) {
            out = (R * out + word.charAt(i)) % mapLength;
        }
        return out;
    }

    public String findVal(String key) {
        int hash = hash(key);
        if (map[hash] == null) {
            return INVALID;
        }
//        System.out.println("\n"+key + " - " + hash);
        while (!map[hash].getKey().equals(key)) {
            hash = (hash+1) % mapLength;
//            System.out.println(key + " - " + hash);
            if (map[hash] == null) {
                return INVALID;
            }
        }
        return map[hash].getVal();
    }

    public void resize() {
        mapLength *= 2;
        Item[] out = new Item[mapLength];
        for (Item i : map) {
            if (i != null) {
//                out[i.hash(mapLength)] = i;
                addItem(out, i);
            }
        }

        map = out.clone();
    }
}
