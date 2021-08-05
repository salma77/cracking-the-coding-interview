package Chapter2.src;

import static org.junit.Assert.*;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class palindrome {
    @Test
    public void testIsPalindromeStack() {
        Node n1 = new Node('a');
        // n1.appendToTail('s');
        // n1.appendToTail('j');
        // n1.appendToTail('s');
        // n1.appendToTail('a');
        assertTrue(n1.isPalindromeStack(n1));
    }

    @Test
    public void testIsPalindrome() {
        Node n1 = new Node('a');
        n1.appendToTail('s');
        n1.appendToTail('j');
        n1.appendToTail('s');
        n1.appendToTail('a');
        assertTrue(n1.isPalindrome(n1));
    }

}
