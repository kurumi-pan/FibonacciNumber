package com.fibonaccinumber;

import java.util.Arrays;
import java.math.*;

class FastFibonacci {
    private BigInteger[] mArray;
    private static final BigInteger INIT = BigInteger.valueOf(0);

    public FastFibonacci(final int n) {
        mArray = new BigInteger[n + 1];
        Arrays.fill(mArray, INIT);
    }

    public BigInteger calc(final int n) {
        if (n < 2)
            return BigInteger.valueOf(n);

        if (mArray[n - 1].compareTo(INIT) == 0) {
            mArray[n - 1] = calc(n - 1);
            mArray[n - 2] = calc(n - 2);
        }
        mArray[n] = mArray[n - 1].add(mArray[n - 2]);
        return mArray[n];
    }
}
