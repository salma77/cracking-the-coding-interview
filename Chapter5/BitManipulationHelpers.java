package Chapter5;

public class BitManipulationHelpers {
    /**
     * Function to do arithmetic right shift to a number repeatedly
     * 
     * @param num   the number to be shifted
     * @param count number of times it will be shifted
     * @return
     */
    public static int repeatedRightArithmeticShift(int num, int count) {
        for (int i = 0; i < count; i++)
            num >>= 1;
        return num;
    }

    /**
     * Function to do logical right shift to a number repeatedly
     * 
     * @param num   the number to be shifted
     * @param count number of times it will be shifted
     * @return
     */
    public static int repeatedRightLogicalShift(int num, int count) {
        for (int i = 0; i < count; i++)
            num >>>= 1;
        return num;
    }

    /**
     * Function to get the ith bit in a number
     * 
     * @param num
     * @param i
     * @return
     */
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /**
     * Function to set the ith bit in a number
     * 
     * @param num
     * @param i
     * @return
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * Function to clear the ith bit of a certain number
     * 
     * @param num
     * @param i
     * @return
     */
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    /**
     * Function to update ith bit with a certain value
     * 
     * @param num
     * @param i
     * @param bit_is_1
     * @return
     */
    public static int updateBit(int num, int i, boolean bit_is_1) {
        int value = bit_is_1 ? 1 : 0;
        return clearBit(num, i) | (value << i);
    }

    /**
     * Function to clear all bits from the most significant bit through i
     * (inclusive)
     * 
     * @param num
     * @param i
     * @return
     */
    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    /**
     * Function to To clear all bits from i through 0 (inclusive)
     * 
     * @param num
     * @param i
     * @return
     */
    public static int clearBitsithrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    /**
     * Function to clear bits from ith bit to jth bit(inclusive)
     * 
     * @param num
     * @param i
     * @param j
     * @return
     */
    public static int clearBitsithroughj(int num, int i, int j) {
        int one = ~0;
        int left = one << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        return num & mask;
    }

    /**
     * Function to get one's complement of a number
     * 
     * @param num
     * @return
     */
    public static int onesComplement(int num) {
        int n = (int) (Math.floor(Math.log(num) / Math.log(2)) + 1);
        return ((1 << n) - 1) ^ num;
    }

    /**
     * Function that counts one bits in a number using Brian Kernighan’s algorithm
     * 
     * @param num
     * @return
     */
    public static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    /**
     * Function to count zero bits in a number
     * 
     * @param num
     * @return
     */
    public static int countZeros(int num) {
        int n = onesComplement(num);
        return countOnes(n);
    }

    public static void getZeroIndices(int num, int[] indices) {
        int i = 0;
        int j = 0;
        while (i<Math.floor(Math.log(num) / Math.log(2))) {
            if (!getBit(num, i)) {
                indices[j] = i;
                j++;
            }
            i++;
        }
    }

    /**
     * Function to check whether a number is a power of 2 or equals zero
     * 
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo(int num) {
        return ((num & (num - 1)) == 0);
    }
}
