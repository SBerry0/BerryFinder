import java.io.BufferedReader;
import java.io.IOException;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Sohum Berry
 **/

public class Finder {

    private static HashMap hashMap;

    public Finder() {
        // Initialize the hashmap
        hashMap = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Partially from DNA student code
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(",");
                String key = items[keyCol];
                String val = items[valCol];
                // Add each item into the hashmap
                hashMap.addItem(new Item(key, val));
            }

        } catch (IOException e) {
            System.out.println("Error opening test file");
            e.printStackTrace();
        }
        br.close();
    }

    public String query(String key){
        return hashMap.findVal(key);
    }
}