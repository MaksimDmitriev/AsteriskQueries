package careepcup.fb;

import java.util.HashSet;
import java.util.Set;

public class Main {

    /*
     * http://www.careercup.com/question?id=5669407776833536
     * http://codereview.stackexchange.com/questions/82848/a-set-of-names-and-a-request-with-asterisks
     *
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
        System.out.println(hasName("f*z*"));
    }

    static String hasName(String query) {
        generateNames();
        return NAMES.contains(query) ? YES : NO;
    }

    static void generateNames() {
        Set<String> generatedNames = new HashSet<String>();
        for (String name : NAMES) {
            int limit = (int) Math.pow(2, name.length());
            for (int i = 1; i < limit; i++) {
                String binary = Integer.toBinaryString(i);
                int k = 0;
                char nameAsArray[] = name.toCharArray();
                for (int j = binary.length() - 1; j >= 0; j--) {
                    if (binary.charAt(j) == '1') {
                        nameAsArray[k] = '*';
                    }
                    k++;
                }
                generatedNames.add(new String(nameAsArray));
            }
        }
        NAMES.addAll(generatedNames);
    }
}
