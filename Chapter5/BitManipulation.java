package Chapter5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitManipulation {
    @Test
    public void testBitHelpers() {
        assertEquals(-5, BitHelpers.repeatedRightArithmeticShift(-18, 2));// (-18=11111101110) =RSA=> (111011=-5)
        assertEquals(0, BitHelpers.repeatedRightLogicalShift(7, 3));
        assertTrue(BitHelpers.getBit(5, 2));
        assertEquals(7, BitHelpers.setBit(5, 1));
        assertEquals(5, BitHelpers.clearBit(7, 1));
        assertEquals(5, BitHelpers.updateBit(7, 1, false));
        assertEquals(3, BitHelpers.clearBitsMSBthroughI(27, 2));
        assertEquals(24, BitHelpers.clearBitsithrough0(27, 2));
        assertEquals(17, BitHelpers.clearBitsithroughj(27, 1, 3));
        assertEquals(18, BitHelpers.onesComplement(45));
        assertEquals(4, BitHelpers.countOnes(45));
        assertEquals(2, BitHelpers.countZeros(45));
        assertTrue(BitHelpers.isPowerOfTwo(16));
        assertFalse(BitHelpers.isPowerOfTwo(19));
    }

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
        n = BitHelpers.clearBitsithroughj(n, i, j);
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
        int ones = BitHelpers.countOnes(num);
        while (num > 0) {
            num--;
            if (BitHelpers.countOnes(num) == ones)
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
        int ones = BitHelpers.countOnes(num);
        while (num > 0) {
            num++;
            if (BitHelpers.countOnes(num) == ones)
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

    /**
     * Function to swap even bits and odd bits of a number
     * 
     * @param num
     * @return
     */
    public int swapBits(int num) {
        int odd_part = num & 0xaaaaaaaa;
        int even_part = num & 0x55555555;
        return (odd_part >>> 1 | even_part << 1);
    }

    @Test
    public void testSwapBits() {
        assertEquals(5, swapBits(10));
        assertEquals(0, swapBits(0));
        assertEquals(2, swapBits(1));
        assertEquals(164, swapBits(88));
        assertEquals(-1073741825, swapBits(2147483647));
    }

    /**
     * Function that draws a horizontal line from point (x1, y) to point (x2, y) on
     * a screen which is represented by an array of bytes
     * 
     * @param screen
     * @param width
     * @param x1
     * @param x2
     * @param y
     */
    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int first_full_byte = x1 / 8;
        int start_offset = x1 % 8;
        int last_full_byte = x2 / 8;
        int end_offset = x2 % 8;

        if (start_offset != 0)
            first_full_byte++;

        if (end_offset != 7)
            last_full_byte--;

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++)
            screen[(width / 8) * y + b] = (byte) 0xff;

        // Create masks for start and end of line
        byte start_mask = (byte) (0xff >> start_offset);
        byte end_mask = (byte) -(0xff >> (end_offset + 1));

        // Set start and end of line
        // xl and x2 are in the same byte
        if ((x1 / 8) == (x2 / 8)) {
            screen[(width / 8) * y + (x1 / 8)] |= ((byte) (start_mask & end_mask));
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    @Test
    public void testDrawLine() {

    }
}
