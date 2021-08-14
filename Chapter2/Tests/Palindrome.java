package Chapter2.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Chapter2.DataStructures.Node;

public class Palindrome {
    @Test
    public void testIsPalindromeStack() {
        Node n1 = new Node('a');
        n1.appendToTail('s');
        n1.appendToTail('j');
        n1.appendToTail('s');
        n1.appendToTail('a');
        assertTrue(n1.isPalindromeStack());
        Node n2 = new Node('a');
        n2.appendToTail('s');
        n2.appendToTail('j');
        assertFalse(n2.isPalindromeStack());
    }

    @Test
    public void testIsPalindrome() {
        Node n1 = new Node('a');
        n1.appendToTail('s');
        n1.appendToTail('j');
        n1.appendToTail('s');
        n1.appendToTail('a');
        assertTrue(n1.isPalindrome());
        Node n2 = new Node('a');
        n2.appendToTail('s');
        n2.appendToTail('j');
        assertFalse(n2.isPalindromeStack());
    }

}
