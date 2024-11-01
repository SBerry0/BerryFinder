import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Sohum Berry
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
//    private static final int DIVISOR = 907;
    private static final int R = 256;
    private static HashMap hashMap;
//    private static ArrayList<Item>[] groups;
//    private static ArrayList<String[]>[] groups;

    public Finder() {
        hashMap = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Partially from DNA student code
        String line;
//        int numLines = 0;
        try {
            while ((line = br.readLine()) != null) {
//                numLines++;
                String[] items = line.split(",");
                String key = items[keyCol];
                String val = items[valCol];
                hashMap.addItem(new Item(key, val));
            }
//            for (Item i: hashMap.getMap()) {
//                if (i!=null)
//                    System.out.print(i.getKey());
//                System.out.print(", ");
//            }
//            for (int i = 0; i < DIVISOR; i++) {
//                System.out.print(groups[i].size() + ((i==DIVISOR-1) ? "" : ", "));
//            }
//            System.out.println("\n"+numLines);

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