package Chapter2.src;

public class two {
    public static void main(String[] args) throws Exception {
        node n1 = new node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        System.out.println(n1.KthNode(n1, 6).data);
    }
}
