package Chapter2.src;

public class four {
    public static void main(String[] args) throws Exception {
        node n1 = new node(2);
        n1.appendToTail(3);
        n1.appendToTail(9);
        n1.appendToTail(1);
        n1.appendToTail(5);
        n1.appendToTail(3);
        n1.appendToTail(7);
        n1 = n1.partition(n1, 5);
        while (n1 != null) {
            System.out.println(n1.data);
            n1 = n1.next;
        }
    }

}
