package Chapter1.src;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length())
            return isSubstring(s1 + s1, s2);
        return false;
    }

    static boolean isSubstring(String s1, String s2) {
        return true;
    }

    // Driver code
    public static void main(String[] args) throws Exception {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
