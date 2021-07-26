package Chapter2.src;
public class seven {
    public static void main(String[] args) throws Exception {
        node common = new node(777);
        node n1 = new node(5);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.insert(common);
        n1.appendToTail(8);
        // while (n1 != null) {
        //     System.out.println(n1.data);
        //     n1=n1.next;
        // }
        node n2 = new node(1);
        n2.appendToTail(3);
        n2.appendToTail(7);
        n2.appendToTail(9);
        n2.appendToTail(22);
        n2.appendToTail(27);
        n2.appendToTail(31);
        n2.insert(common);
        n2.appendToTail(2);
        n2.appendToTail(6);

        node x = n1.Intersection(n1, n2);
        System.out.println(x);
        System.out.println(common);
        
        node n3 = new node(44);
        n3.appendToTail(3);
        n3.appendToTail(2);
        n3.appendToTail(6);

        node n4 = n3;
        n4.appendToTail(3);
        n4.appendToTail(4);
        n4.appendToTail(7);
        n4.appendToTail(22);
        n4.appendToTail(9);
        n4.appendToTail(1);
        n4.appendToTail(8);
        
        // node y = n3.Intersection(n3, n4);
        // System.out.println(y);
        // System.out.println(n3);
        // System.out.println(n4);
    }
}
