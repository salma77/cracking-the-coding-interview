package Chapter3.src;

import java.util.Stack;

public class StacksAndQueues {

    public static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!s.isEmpty()) {
            int dummy = s.pop();
            while (!temp.isEmpty() && temp.peek() > dummy) {
                s.push(temp.pop());
            }
            temp.push(dummy);
        }

        while (!temp.isEmpty())
            s.push(temp.pop());
    }

    public static void main(String[] args) {
        // StackMin salma = new StackMin();
        // salma.push(3);
        // salma.push(1);
        // System.out.println(salma.getMin());
        // salma.pop();
        // salma.push(7);
        // System.out.println(salma.getMin());
        // salma.push(2);
        // salma.push(9);
        // System.out.println(salma.getMin());

        // QueueViaStacks<Integer> salma = new QueueViaStacks<Integer>();
        // salma.add(10);
        // salma.add(12);
        // salma.add(16);
        // System.out.println(salma.remove());
        // salma.add(18);
        // System.out.println(salma.remove());
        // System.out.println(salma.remove());
        // System.out.println(salma.remove());
        // System.out.println(salma.isEmpty());

        Stack<Integer> salma = new Stack<Integer>();
        salma.push(10);
        salma.push(99);
        salma.push(1);
        salma.push(7);
        sort(salma);
        salma.push(4);
        salma.push(3);
        salma.push(22);
        while (!salma.isEmpty())
            System.out.println(salma.pop());
    }
}
