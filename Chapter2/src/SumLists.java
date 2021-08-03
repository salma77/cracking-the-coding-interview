package Chapter2.src;

public class SumLists {
    public static void main(String[] args) throws Exception {
        //First approach
        Node n1 = new Node(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail('+');
        n1.appendToTail(1);
        n1.appendToTail(1);
        n1.appendToTail(1);
        Node sum = n1.sumLists(n1);

        System.out.println("Function Result: ");
        while (sum != null) {
            System.out.println(sum.data);
            sum = sum.next;
        }
        System.out.println("Actual Result: " + (7777 + 111));

        //Recursive approach
        Node n2 = new Node(7);
        n2.appendToTail(7);
        n2.appendToTail(7);
        n2.appendToTail(7);
        Node n3 = new Node(1);
        n3.appendToTail(1);
        n3.appendToTail(1);
        Node n4 = n2.sumListsRecursive(n2, n3, 0);
        while (n4 != null) {
            System.out.println(n4.data);
            n4 = n4.next;
        }
    }

}