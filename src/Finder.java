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
    private static final int DIVISOR = 3;
    private static ArrayList<String>[] groups;

    public Finder() {
        groups = new ArrayList[DIVISOR];
        for (int i = 0; i < DIVISOR; i++) {
            groups[i] = new ArrayList<String>();
        }
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        // From SpellCheck student code
        String line;
        try {
            line = br.readLine();

            // Update instance variables with test data
            int n = Integer.parseInt(line);
            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                line = br.readLine();
                words[i] = line;
            }
//            return words;
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
        return INVALID;
    }
}