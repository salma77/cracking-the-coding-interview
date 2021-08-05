package Chapter1.src;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length())
            return isSubstring(s1 + s1, s2);
        return false;
    }

    static boolean isSubstring(String s1, String s2) {
        return true;
    }

    @Test
    public void testIsRotation() {
        assertTrue(isRotation("waterbottle", "erbottlewat"));
        assertFalse(isRotation("waterbottle", "erbottle"));
    }

}
