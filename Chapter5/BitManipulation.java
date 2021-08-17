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
    public void testCountFlips(){
        assertEquals(0, countFlips(7,7));
        assertEquals(1, countFlips(63,55));
        assertEquals(2, countFlips(29,15));
        assertEquals(4, countFlips(213,28));
        assertEquals(8, countFlips(255,0));
    }
}
