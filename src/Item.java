public class Item {
    private static final int R = 256;
    private String key;
    private String val;

    public Item(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }

    public int hash(int mapLength) {
        int out = 0;
        for (int i = 0; i < key.length(); i++) {
            out = (R * out + key.charAt(i)) % mapLength;
        }
        return out;
    }
}
