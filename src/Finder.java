import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }

    // public int hash (String productName, String companyName)
    // for every letter
    // multiply the Radix by the current index of the string
    // modulus each time by a relatively small number (maybe 500 million)
    // Do the same thing for the companyName
    // Then find some way to keep the number small but have a unique combination of both hashes
    // create a map with length of highest possible combination value
    // in each index have companyName, productName
    // return the correct substring
}