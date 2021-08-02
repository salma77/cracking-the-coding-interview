package Chapter1.src;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z)
 */

public class StringCompression {
    /**
     * The function iterates through the string, copying characters to a new string
     * and counting the character repeats, check if the current character is the
     * same as the next character. If not, add its compressed version to the result.
     * 
     * @param s the string to be compressed
     * @return
     */
    public static String compressString(String s) {
        int consecutive = 0;
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            consecutive++;
            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                t += "" + s.charAt(i) + consecutive;
                consecutive = 0;
            }
        }
        return t.length() > s.length() ? s : t;
    }

    // Driver code
    public static void main(String[] args) throws Exception {
        System.out.println(compressString("aabbbcdhhhhhhl"));
    }
}
