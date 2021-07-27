package Chapter3.src;

public class ThreeInOne {
    // Questions & Assumptions
    // 1- Is the array static or dynamic? I'll assume it's static, but this will
    // mean that the stack sizes would be predefined
    // 2- Should I implement all the methods of the stack class? I will

    /***
     * The idea is that each stack takes the indices of multiples of 1, 2, & 3. To
     * peek I will look at the last non-null element of (index+1) % (1 or 2 or 3) To
     * pop I will replace the element with a predefined character (- for character
     * array or -1 for integers)
     */
    private Character stacks[] = new Character[100];

    public Character peek(int id) {
        for (int i = id - 1; i < 100; i += 3) {
            if (stacks[i] == null)
                return stacks[i - 3];
        }
        return null;
    }

    public Character pop(int id) {
        Character popped = null;
        for (int i = id - 1; i < 100; i += 3) {
            if (stacks[i] == null) {
                popped = stacks[i - 3];
                stacks[i - 3] = null;
                break;
            }
        }
        return popped;
    }

    public void push(int id, Character pushed) {
        for (int i = id - 1; i < 100; i += 3) {
            if (stacks[i] == null) {
                stacks[i] = pushed;
                return;
            }
        }
    }

    public boolean isEmpty(int id) {
        // It's ok to loop from the bottom of the stack(i.e the beginning of the array)
        for (int i = id - 1; i < 100; i += 3) {
            if (stacks[i] != null)
                return false;
        }
        return true;
    }

}
