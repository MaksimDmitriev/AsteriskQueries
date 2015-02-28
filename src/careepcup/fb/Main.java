package careepcup.fb;

import java.util.HashSet;
import java.util.Set;

public class Main {

    /*
     * This class offers constant time performance for the basic operations (add, remove, contains
     * and size), assuming the hash function disperses the elements properly among the buckets.
     */
    private static final Set<String> NAMES = new HashSet<String>();
    private static final String YES = "YES";
    private static final String NO = "NO";

    static {
        NAMES.add("hasad");
        NAMES.add("ahmed");
        NAMES.add("moustafa");
        NAMES.add("fizo");
    }

    public static void main(String[] args) {
        System.out.println(hasName("has**"));
    }

    static boolean generate(char[] query, int length, String prefix) {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (length > 1) {
                boolean result = generate(query, length - 1, prefix + letter);
                if (result) {
                    return true;
                }
            }
            else {
                char []generated = (prefix + letter).toCharArray();
                for (int i = 0, j = 0; i < query.length; i++) {
                    if (query[i] == '*') {
                        query[i] = generated[j];
                        j++;
                    }
                }
                if (NAMES.contains(query.toString())) {
                    return true;
                }
                // TODO: reset to asterisks
            }
        }
        return false;
    }
    
    static String hasName(String query) {
        int fromIndex = 0;
        int asteriskCount = 0;
        while ((fromIndex = query.indexOf("*", fromIndex)) != -1) {
            asteriskCount++;
            fromIndex++;
        }
        if (asteriskCount == 0) {
            return NAMES.contains(query) ? YES : NO;
        } else {
            return generate(query.toCharArray(), asteriskCount, "") ? YES : NO;
        }
    }
}
