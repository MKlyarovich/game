package com.company.app;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * The class to the maintain operations with Solution
 */
public class Solution {

    /**
     * Method returns maximal result that can be achieved for {@code a} array.
     *
     * @param a array of int values
     * @return maximal result
     */
    public int solution(int[] a) {
        final int maxCubeValue = 6;
        final int nextAfterMinCubeValue = 2;

        final int lengthArray = a.length;

        int[] result = new int[lengthArray];
        result[0] = a[0];

        IntStream.range(1, lengthArray)
                .forEach(i -> {
                    result[i] = result[i - 1];

                    IntStream.rangeClosed(nextAfterMinCubeValue, maxCubeValue)
                            .filter(j -> i >= j)
                            .forEach(j -> result[i] = Math.max(result[i], result[i - j]));

                    result[i] = result[i] + a[i];
                });

        return result[lengthArray - 1];
    }

    /**
     * Generation of a new array with a given {@code length} length.
     * Length should be within the range [2..100,000].
     * Each element of array A is an integer within the range [−10,000..10,000].
     *
     * @param length length of generate array
     * @return generated array
     */
    public int[] generateArrays(int length) {
        final int minArrayLength = 2;
        final int maxArrayLength = 100000;
        final int minRange = -10000;
        final int maxRange = 10000;

        if (length < minArrayLength || length > maxArrayLength) {
            throw new IllegalArgumentException(String.format("Length of array must be between %s and %s", minArrayLength, maxArrayLength));
        }

        return new Random().ints(length, minRange, maxRange + 1)
                .toArray();
    }
}
