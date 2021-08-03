package Chapter2.src;
public class Intersection {
    public static void main(String[] args) throws Exception {
        Node common = new Node(777);
        Node n1 = new Node(5);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.insert(common);
        n1.appendToTail(8);
        // while (n1 != null) {
        //     System.out.println(n1.data);
        //     n1=n1.next;
        // }
        Node n2 = new Node(1);
        n2.appendToTail(3);
        n2.appendToTail(7);
        n2.appendToTail(9);
        n2.appendToTail(22);
        n2.appendToTail(27);
        n2.appendToTail(31);
        n2.insert(common);
        n2.appendToTail(2);
        n2.appendToTail(6);

        Node x = n1.intersection(n1, n2);
        System.out.println(x);
        System.out.println(common);
        
        Node n3 = new Node(44);
        n3.appendToTail(3);
        n3.appendToTail(2);
        n3.appendToTail(6);

        Node n4 = n3;
        n4.appendToTail(3);
        n4.appendToTail(4);
        n4.appendToTail(7);
        n4.appendToTail(22);
        n4.appendToTail(9);
        n4.appendToTail(1);
        n4.appendToTail(8);
        
        // Node y = n3.intersection(n3, n4);
        // System.out.println(y);
        // System.out.println(n3);
        // System.out.println(n4);
    }
}
