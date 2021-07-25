package Chapter1.src;

public class six {
    public static void main(String[] args) throws Exception {
        System.out.println(compress("aabbbcdhhhhhhl"));
    }

    public static String compress(String s) {
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
}
