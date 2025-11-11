public class HashDataSet {
    String[] keys;
    String[] values;
    int tableSize;
    int n;
    public HashDataSet() {
        // Arbitrary prime number
        tableSize = 8429;
        keys = new String[8429];
        values = new String[8429];
        n = 0;
    }
    int hash(String key) {
        long h = 0;
        // h can multiply by itself over time to have separate powers,
        // and continuously mods by tableSize
        // to make sure that it never goes over the int limit
        for (int i = 0; i < key.length(); i++) {
            h = (h * Finder.RADIX + key.charAt(i)) % tableSize;
        }
        return (int) h;
    }
    void add(String key, String value) {
        // Checks to see if alpha is more than 0.5 in order to keep
        // amortized constant time
        if ((double) n / tableSize > 0.5) {
            resize();
        }
        int keyHash = hash(key);
        int index = keyHash;
        // Loops through array until it finds an empty spot to put the key and value
        while (keys[index] != null) {
            // Mods by tableSize in order to wrap around
            index = (index + 1) % tableSize;
        }
        keys[index] = key;
        values[index] = value;
        n++;
    }
    String get(String key) {
        int index = hash(key);
        // Continues through loop until it finds a match or the index is null
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % tableSize;
        }
        // Returns either the value or null
        // (in the case that hashing the key goes to a null index)
        return values[index];
    }
    void resize() {
        // Adds 1 to keep the size odd
        tableSize = tableSize * 2 + 1;
        String[] oldVals = values;
        String[] oldKeys = keys;
        values = new String[tableSize];
        keys = new String[tableSize];
        // Resets n to 1 since each key is getting rehashed
        n = 0;
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null) {
                add(oldKeys[i], oldVals[i]);
            }
        }
    }

}
