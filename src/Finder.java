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
    private static final int DIVISOR = 17;
    private static ArrayList<String>[] groups;

    public Finder() {
        groups = new ArrayList[DIVISOR];
        for (int i = 0; i < DIVISOR; i++) {
            groups[i] = new ArrayList<>();
        }
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Partially from DNA student code
        String line;
        int numLines = 0;
        try {
            while ((line = br.readLine()) != null) {
                numLines++;
                String[] items = line.split(",");
                String key = items[keyCol];
                String val = items[valCol];
                hash(key).add(val);
//                hash(key).add(new String[]{key, val});
            }
//            for (int i = 0; i < DIVISOR; i++) {
//                System.out.println(groups[i]);
//            }
            for (int i = 0; i < DIVISOR; i++) {
                System.out.print(groups[i].size() + ((i==DIVISOR-1) ? "" : ", "));
            }
            System.out.println("\n"+numLines);

        } catch (IOException e) {
            System.out.println("Error opening test file");
            e.printStackTrace();
        }
        br.close();
    }

    public ArrayList<String> hash(String in) {
        int sum = 0;
        for (int i = 0; i < in.length(); i++) {
            sum += in.charAt(i);
        }
        return groups[sum % DIVISOR];
    }

    public String query(String key){
        // TODO: Complete the query() function!
//        ArrayList<String[]> bucket = hash(key);
//        for (String[] s: bucket) {
//            if (s[0].equals(key)) {
//                return s[1];
//            }
//        }
        return INVALID;
    }
}