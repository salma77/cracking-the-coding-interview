package Chapter5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitManipulation {
    /**
     * Function to insert M into N (32-bit numbers) such that M starts at bit j and
     * ends at bit i
     * 
     * @param m number to be inserted
     * @param n number to be inserted into
     * @param i start index
     * @param j end index
     * @return
     */
    public int insertInto(int m, int n, int i, int j) {
        n = BitManipulationHelpers.clearBitsithroughj(n, i, j);
        return n + (m << i);
    }

    @Test
    public void testInsertInto() {
        int m = 19; // 10011
        int n = 1024; // 10000000000
        assertEquals(1100, insertInto(m, n, 2, 6));// 10001001100
        m = 101;// 1100101
        n = 4095;// 111111111111
        assertEquals(3263, insertInto(m, n, 5, 11));// 110010111111
        m = 31;// 11111
        n = 2730;// 101010101010
        assertEquals(2810, insertInto(m, n, 3, 7));// 101011111010
    }

    /**
     * Function to convert a double number to binary
     * 
     * @param num
     * @return
     */
    public String binaryToString(double num) {
        if (num >= 1 || num <= 0)
            return "ERROR";
        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        while (num > 0) {
            if (binary.length() > 34)
                return "ERROR";
            double r = num * 2;
            if (r >= 1) {
                binary.append("1");
                num = r - 1;
            } else {
                binary.append("0");
                num = r;
            }
        }
        return binary.toString();
    }

    @Test
    public void testBinaryToString() {
        assertEquals("ERROR", binaryToString(17.0)); // more than 1
        assertEquals("ERROR", binaryToString(-17.0));// less than 0
        assertEquals("ERROR", binaryToString(0.2)); // more than 32-bit
        assertEquals("0.1", binaryToString(0.5));
        assertEquals("0.101", binaryToString(0.625));
        assertEquals("0.1011", binaryToString(0.6875));
        assertEquals("0.101101", binaryToString(0.703125));
        assertEquals("0.111011", binaryToString(0.921875));
    }

    /**
     * Function that returns count of the longest sequence of ones in a number given
     * that we can only flip one bit from zero to one
     * 
     * @param num
     * @return
     */
    public int countLongestSequence(int num) {
        if (~num == 0)
            return Integer.BYTES * 8;
        int curr_len = 0;
        int prev_len = 0;
        int max_len = 1;
        while (num != 0) {
            if ((num & 1) == 1)
                curr_len++;
            else if ((num & 1) == 0) {
                prev_len = (num & 2) == 0 ? 0 : curr_len;
                curr_len = 0;
            }
            max_len = Math.max(prev_len + curr_len + 1, max_len);
            num >>>= 1;
        }
        return max_len;
    }

    @Test
    public void testCountLongestSequence() {
        assertEquals(1, countLongestSequence(0));// 0
        assertEquals(2, countLongestSequence(1));// 1
        assertEquals(8, countLongestSequence(1775));// 11011101111
        assertEquals(5, countLongestSequence(463)); // 111001111
        assertEquals(3, countLongestSequence(2730));// 101010101010
    }

    /**
     * Function to get the next smaller number with the same number of one bits
     * (brute force solution)
     * 
     * @param num
     * @return
     */
    public int getNextSmallerBruteForce(int num) {
        int ones = BitManipulationHelpers.countOnes(num);
        while (num > 0) {
            num--;
            if (BitManipulationHelpers.countOnes(num) == ones)
                return num;
        }
        return 0;
    }

    @Test
    public void testGetNextSmallerBruteForce() {
        assertEquals(75, getNextSmallerBruteForce(77));
        assertEquals(1, getNextSmallerBruteForce(2));
        assertEquals(5, getNextSmallerBruteForce(6));
        assertEquals(4, getNextSmallerBruteForce(8));
    }

    /**
     * Function to get the next larger number with the same number of one bits
     * (brute force solution)
     * 
     * @param num
     * @return
     */
    public int getNextLargerBruteForce(int num) {
        int ones = BitManipulationHelpers.countOnes(num);
        while (num > 0) {
            num++;
            if (BitManipulationHelpers.countOnes(num) == ones)
                return num;
        }
        return num;
    }

    @Test
    public void testGetNextLargerBruteForce() {
        assertEquals(78, getNextLargerBruteForce(77));
        assertEquals(4, getNextLargerBruteForce(2));
        assertEquals(9, getNextLargerBruteForce(6));
        assertEquals(11, getNextLargerBruteForce(7));
        assertEquals(16, getNextLargerBruteForce(8));
    }

    /**
     * Function to get the next smaller number with the same number of one bits
     * 
     * @param num
     * @return
     */
    public int getNextSmaller(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c == 0)
            return -1;

        while (((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }

        int p = c0 + c1;
        num &= ((~0) << (p + 1));

        int mask = (1 << (c1 + 1)) - 1; // zeros with 1 at position (c1+1)
        num |= mask << (c0 - 1); // (c1+1) ones followed by (c0-1) zeros

        return num;
    }

    @Test
    public void testGetNextSmaller() {
        assertEquals(75, getNextSmaller(77));
        assertEquals(1, getNextSmaller(2));
        assertEquals(5, getNextSmaller(6));
        assertEquals(4, getNextSmaller(8));
    }

    /**
     * Function to get the next larger number with the same number of one bits
     * 
     * @param num
     * @return
     */
    public int getNextLarger(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;
        
        while (((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        // Numbers like 111111100000 don't have a larger number
        if (c0 + c1 == 31 || c0 + c1 == 0)
            return -1;

        int p = c0 + c1; // position of rightmost non-trailing zero

        num |= (1 << p); // flip the zero at p
        num &= ~((1 << p) - 1); // clear all the bits to the right of this zero
        num |= (1 << (c1 - 1)) - 1; // insert (c1-1) ones to the right of p such that ones are on the right

        return num;
    }

    @Test
    public void testGetNextLarger() {
        assertEquals(78, getNextLarger(77));
        assertEquals(4, getNextLarger(2));
        assertEquals(9, getNextLarger(6));
        assertEquals(11, getNextLarger(7));
        assertEquals(16, getNextLarger(8));
    }

    /**
     * Function to get the next smaller number with the same number of one bits
     * (Arithmetic Approach)
     * 
     * @param num
     * @return
     */
    public int getNextSmallerArithmetic(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c == 0)
            return -1;

        while (((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }
        return num - (1 << c1) - (1 << (c0 - 1)) + 1;
    }

    @Test
    public void testGetNextSmallerArithmetic() {
        assertEquals(75, getNextSmallerArithmetic(77));
        assertEquals(1, getNextSmallerArithmetic(2));
        assertEquals(5, getNextSmallerArithmetic(6));
        assertEquals(4, getNextSmallerArithmetic(8));
    }

    /**
     * Function to get the next larger number with the same number of one bits
     * (Arithmetic Approach)
     * 
     * @param num
     * @return
     */
    public int getNextLargerArithmetic(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        return num + (1 << c0) + (1 << (c1 - 1)) - 1;
    }

    @Test
    public void testGetNextLargerArithmetic() {
        assertEquals(78, getNextLargerArithmetic(77));
        assertEquals(4, getNextLargerArithmetic(2));
        assertEquals(9, getNextLargerArithmetic(6));
        assertEquals(11, getNextLargerArithmetic(7));
        assertEquals(16, getNextLargerArithmetic(8));
    }

    /**
     * Function to count number of bits that need to be flipped to convert integer A
     * to integer B
     * 
     * @param A
     * @param B
     * @return
     */
    public int countFlips(int A, int B) {
        int count = 0;
        for (int i = A ^ B; i != 0; i = i & (i - 1))
            count++;
        return count;
    }

    @Test
    public void testCountFlips() {
        assertEquals(0, countFlips(7, 7));
        assertEquals(1, countFlips(63, 55));
        assertEquals(2, countFlips(29, 15));
        assertEquals(4, countFlips(213, 28));
        assertEquals(8, countFlips(255, 0));
    }

}
