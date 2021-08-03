package Chapter2.src;

public class KthToLast {
    public static void main(String[] args) throws Exception {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        System.out.println(n1.kthNode(n1, 6).data);
    }
}
