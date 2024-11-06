// HashMap.java by Sohum Berry
public class HashMap {
    private static final int R = 43;
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

    // Inserting an item into the hashmap
    public void addItem(Item item) {
        int hash = hash(item.getKey());
        while (map[hash] != null) {
            hash = (hash+1)%mapLength;
            // If over half are full, resize and get the new hash
            if (numItems*1.0/mapLength > 0.5) {
                resize();
                hash = hash(item.getKey());
            }
        }
        // Set the map accordingly
        map[hash] = item;
        // Increment the number of items in the map
        numItems++;
    }

    public void addResizeItem(Item[] itemMap, Item item) {
        int hash = hash(item.getKey());
        // Linear probing if the position in the map is unavailable
        while (itemMap[hash] != null) {
            hash = (hash+1)%mapLength;
            // No need to resize, this is filling in the resized map so it won't overflow
        }
        itemMap[hash] = item;
    }

    // Hashing using Horner's Method
    public int hash(String word) {
        int out = 0;
        for (int i = 0; i < word.length(); i++) {
            out = (R * out + word.charAt(i)) % mapLength;
        }
        return out;
    }

    // Retrieve the value associated with a key in the hashmap
    public String findVal(String key) {
        // Find hash of the key
        int hash = hash(key);
        if (map[hash] == null) {
            return INVALID;
        }
        // Linear probing. While the hash isn't the key, increment to the next one
        while (!map[hash].getKey().equals(key)) {
            hash = (hash+1) % mapLength;
            // Check if there is no item along the chain, indicating no value for the key
            if (map[hash] == null) {
                return INVALID;
            }
        }
        return map[hash].getVal();
    }

    // Resize the map to make it double the size
    public void resize() {
        mapLength *= 2;
        Item[] out = new Item[mapLength];
        // Add every item in the old map to the new map
        for (Item i : map) {
            if (i != null) {
                addResizeItem(out, i);
            }
        }
        map = out;
    }
}
