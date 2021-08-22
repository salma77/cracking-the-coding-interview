package Chapter6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Puzzles {
    /**
     * The Sieve of Eratosthenes is a highly efficient way to generate a list of
     * primes. It works by recognizing that all non-prime numbers are divisible by a
     * prime number.
     * 
     * @param max get primes from 2...max
     * @return
     */
    public boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        init(flags);
        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    /**
     * Function to initialize a boolean array with true for all indices except 1 and
     * 0
     * 
     * @param flags
     */
    private void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++)
            flags[i] = true;
    }

    /**
     * Function to cross off remaining multiples of a prime number, by setting their
     * flag to false
     * 
     * @param flags
     * @param prime
     */
    private void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime)
            flags[i] = false;
    }

    /**
     * Function to get next prime number whose flag equals true
     * 
     * @param flags
     * @param prime
     * @return
     */
    private int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next])
            next++;
        return next;
    }

    @Test
    public void testSieveOfEratosthenes() {
        int max = 9;
        boolean[] test = sieveOfEratosthenes(max);
        for (int i = 3; i < max; i += 2)
            assertTrue(test[i]);
    }

    // The point when using the scale is to number all the bottles from 1...20 then
    // add 1 pill from bottle number 1 and 2 pills from bottle number 2 and so on.
    // That way
    public int heavyPill(double[] bottles) {
        double sum = 0;
        for (int i = 0; i < bottles.length; i++) {
            sum += bottles[i] * (i + 1);
        }
        return (int) Math.ceil((sum-210.0)*10);
    }

    @Test
    public void testHeavyPill() {
        double[] bottles = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.1 };
        assertEquals(20, heavyPill(bottles));
        double [] bottles2 = { 1.1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        assertEquals(1, heavyPill(bottles2));
        double [] bottles3 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        assertEquals(10, heavyPill(bottles3));
    }
}
