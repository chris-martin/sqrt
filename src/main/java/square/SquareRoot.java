package square;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SquareRoot {
    public static final int BITS = 10000;

    private static BigInteger n =
            new BigInteger(BITS, new SecureRandom()).pow(2);

    public static void answer(BigInteger root) {
        if (n.divide(root).equals(root)) {
            // The goal is to reach this line
            System.out.println("Square root!");
        }
    }
}
