package Chapter2.src;

public class six {
    public static void main(String[] args) throws Exception {
        // node n1 = new node(1);
        // n1.appendToTail(2);
        // n1 = n1.appendToHead(n1, 3);
        // while (n1 != null) {
        // System.out.println(n1.data);
        // n1=n1.next;
        // }
        node n1 = new node('a');
        n1.appendToTail('s');
        n1.appendToTail('j');
        // n1.appendToTail('s');
        // n1.appendToTail('a');
        // System.out.println(n1.isPalindrome(n1));
        System.out.println(n1.isPalindromeStack(n1));
    }

}
