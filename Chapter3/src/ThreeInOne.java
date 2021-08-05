package Chapter3.src;

/**
 * Stack implementation using 3 stacks
 */
public class ThreeInOne {
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
