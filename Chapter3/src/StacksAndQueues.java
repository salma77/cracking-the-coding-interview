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
        // StackMin stack1 = new StackMin();
        // stack1.push(3);
        // stack1.push(1);
        // System.out.println(stack1.getMin());
        // stack1.pop();
        // stack1.push(7);
        // System.out.println(stack1.getMin());
        // stack1.push(2);
        // stack1.push(9);
        // System.out.println(stack1.getMin());

        // QueueViaStacks<Integer> stack1 = new QueueViaStacks<Integer>();
        // stack1.add(10);
        // stack1.add(12);
        // stack1.add(16);
        // System.out.println(stack1.remove());
        // stack1.add(18);
        // System.out.println(stack1.remove());
        // System.out.println(stack1.remove());
        // System.out.println(stack1.remove());
        // System.out.println(stack1.isEmpty());

        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(10);
        stack1.push(99);
        stack1.push(1);
        stack1.push(7);
        sort(stack1);
        stack1.push(4);
        stack1.push(3);
        stack1.push(22);
        while (!stack1.isEmpty())
            System.out.println(stack1.pop());
    }
}
