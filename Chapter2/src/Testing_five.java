package Chapter2.src;

public class Testing_five {
    public static void main(String[] args) throws Exception {
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
            sum=sum.next;
        }
        System.out.println("Actual Result: " + (7777+111));
    }

}