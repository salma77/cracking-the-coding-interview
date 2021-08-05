package Chapter3.src;

import java.util.*;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this.
 * 
 * SetOfStacks is composed of several stacks and it creates a new stack once the
 * previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * behave identically to a single stack (that is, pop () should return the same
 * values as it would if there were just a single stack
 */
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

    public int pop() throws EmptyStackException {
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
