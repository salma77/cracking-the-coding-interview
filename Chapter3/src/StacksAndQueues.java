package Chapter3.src;
public class StacksAndQueues {
    public static void main(String[] args) {
        StackMin salma = new StackMin();
        salma.push(3);
        salma.push(1);
        System.out.println(salma.getMin());
        salma.pop();
        salma.push(7);
        System.out.println(salma.getMin());
        salma.push(2);
        salma.push(9);
        System.out.println(salma.getMin());
    }
}
