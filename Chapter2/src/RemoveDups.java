package Chapter2.src;


public class RemoveDups {
    public static void main(String[] args) throws Exception {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        n1.removeDup();
        while (n1 != null) {
            System.out.println(n1.data);
            n1=n1.next;
        }
    }
}
