import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [Niam]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    public static final int RADIX = 256;
    private HashDataSet hashMap;

    public Finder() {
        hashMap = new HashDataSet();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Reads the line in the csv file and adds it to the hashMap
        String line = br.readLine();
        while (line != (null)) {
            String[] values = line.split(",");
            hashMap.add(values[keyCol], values[valCol]);
            line = br.readLine();
        }
        br.close();


    }

    public String query(String key){
        // Uses the get method to find the value associated with the key
        String value = hashMap.get(key);
        if (value == null) {
            return INVALID;
        }
        return value;
    }
}