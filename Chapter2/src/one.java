package Chapter2.src;


public class one {
    public static void main(String[] args) throws Exception {
        node n1 = new node(1);
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
