// Item.java by Sohum Berry
public class Item {
    private String key;
    private String val;

    // Item stores a key-value pair for storage in the hashmap
    public Item(String key, String val) {
        this.key = key;
        this.val = val;
    }

    // Getters
    public String getKey() {
        return key;
    }
    public String getVal() {
        return val;
    }
}
