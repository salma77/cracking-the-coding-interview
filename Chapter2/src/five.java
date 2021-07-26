package Chapter2.src;

public class five {
    public static void main(String[] args) throws Exception {
        //First approach
        node n1 = new node(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail('+');
        n1.appendToTail(1);
        n1.appendToTail(1);
        n1.appendToTail(1);
        node sum = n1.sumLists(n1);

        System.out.println("Function Result: ");
        while (sum != null) {
            System.out.println(sum.data);
            sum = sum.next;
        }
        System.out.println("Actual Result: " + (7777 + 111));

        //Recursive approach
        node n2 = new node(7);
        n2.appendToTail(7);
        n2.appendToTail(7);
        n2.appendToTail(7);
        node n3 = new node(1);
        n3.appendToTail(1);
        n3.appendToTail(1);
        node n4 = n2.sumListsRecursive(n2, n3, 0);
        while (n4 != null) {
            System.out.println(n4.data);
            n4 = n4.next;
        }
    }

}