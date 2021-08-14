package Chapter3.src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class StacksAndQueues {
    /**
     * Function that sorts a stack (using another stack) where the smallest items
     * are on the top
     * 
     * @param s
     */
    public static void sort(Stack<Integer> s) {
        if (s.isEmpty())
            return;

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

    @Test
    public void testSort() {
        // Test case 1: random numbers
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(10);
        stack1.push(99);
        stack1.push(1);
        stack1.push(7000);
        stack1.push(4);
        stack1.push(3);
        stack1.push(22);
        sort(stack1);
        int[] nums = { 10, 99, 1, 7000, 4, 3, 22 };
        Arrays.sort(nums);

        assertFalse(stack1.isEmpty());
        int i = 0;
        while (!stack1.isEmpty()) {
            int min = stack1.pop();
            assertEquals(min, nums[i]);
            i++;
        }
        // Test case 2: all the same element, odd number of elements
        stack1.push(0);
        stack1.push(0);
        stack1.push(0);
        stack1.push(0);
        stack1.push(0);
        sort(stack1);
        while (!stack1.isEmpty()) {
            int min = stack1.pop();
            assertEquals(min, 0);
        }
        // Test case 3: negative numbers, duplicate numbers
        stack1.push(0);
        stack1.push(1020);
        stack1.push(-1);
        stack1.push(7);
        stack1.push(-13);
        stack1.push(3);
        stack1.push(7);
        stack1.push(1020);
        sort(stack1);
        int[] nums2 = { 0, -1, 7, -13, 3, 7, 1020, 1020 };
        Arrays.sort(nums2);
        i = 0;
        while (!stack1.isEmpty()) {
            int min = stack1.pop();
            assertEquals(min, nums2[i]);
            i++;
        }
        // Test case 4: empty stack
        assertTrue(stack1.isEmpty());
        sort(stack1);

    }

    @Test
    public void testStackMin() {
        StackMin stack1 = new StackMin();
        stack1.push(3);
        stack1.push(1);
        // stack: 1,3 --> min=1
        assertEquals(stack1.getMin(), 1);
        stack1.pop();
        stack1.push(7);
        // stack: 7,3 --> min=3
        assertEquals(stack1.getMin(), 3);
        stack1.push(2);
        stack1.push(9);
        // stack: 9,2,7,3 --> min=2
        assertEquals(stack1.getMin(), 2);
        stack1.push(0);
        // stack: 0,9,2,7,3 --> min=0
        assertEquals(stack1.getMin(), 0);
        stack1.push(-5);
        // stack: -5,0,9,2,7,3 --> min=-5
        assertEquals(stack1.getMin(), -5);
        stack1.push(-2);
        // stack: -2,-5,0,9,2,7,3 --> min=-5
        assertEquals(stack1.getMin(), -5);
    }

    @Test
    public void testQueueViaStacks() {
        QueueViaStacks<Integer> stack1 = new QueueViaStacks<Integer>();
        stack1.enqueue(10);
        stack1.enqueue(12);
        stack1.enqueue(16);
        assertEquals(stack1.dequeue(), Integer.valueOf(10));
        stack1.enqueue(18);
        assertEquals(stack1.dequeue(), Integer.valueOf(12));
        assertEquals(stack1.dequeue(), Integer.valueOf(16));
        assertEquals(stack1.dequeue(), Integer.valueOf(18));
        assertTrue(stack1.isEmpty());
    }

}
