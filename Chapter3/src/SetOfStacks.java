package Chapter3.src;

import java.util.*;

public class SetOfStacks {
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    Stack<Integer> last = stacks.get(stacks.size() - 1);
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int item) {
        if (last != null && last.capacity() < capacity) {
            last.push(item);
            return;
        } else {
            Stack<Integer> s = new Stack<Integer>();
            s.push(item);
            stacks.add(s);
        }
    }

    public int pop() {
        if (last == null)
            throw new EmptyStackException();
        int item = last.pop();
        if (last.capacity() == 0)
            stacks.remove(last);
        return item;
    }

    public boolean isEmpty() {
        return last == null || last.isEmpty();
    }

}
