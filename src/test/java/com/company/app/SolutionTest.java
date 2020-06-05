package com.company.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The test to the maintain operations with Solution.
 */
public class SolutionTest {

    /**
     * Getting a valid result for fixed array from Task.
     */
    @Test
    public void shouldResultValueWhenArrayFromTask() {
        // Prepare
        int[] array = {1, -2, 0, 9, -1, -2};

        // Act
        int result = new Solution().solution(array);

        // Check
        assertEquals("Unexpected value of result", 8, result);
    }

    /**
     * Getting a valid result for fixed array.
     */
    @Test
    public void shouldResultWhenFixArray() {
        // Prepare
        int[] array = {1, -2, 0, 9, -1, -2, 7, -10, 8, 2, 2, 3, -5};

        // Act
        int result = new Solution().solution(array);

        // Check
        assertEquals("Unexpected value of result", 27, result);
    }

    /**
     * Comparing the maximum result with 0 for a generated array with a length of 100.
     */
    @Test
    public void shouldResultWhenLengthOneHundred() {
        // Prepare
        Solution solution = new Solution();
        int[] array = solution.generateArrays(100);

        // Act
        int result = solution.solution(array);

        // Check
        assertNotEquals("Unexpected value of result", 0, result);
    }

    /**
     * Getting the valid length of the generated array.
     */
    @Test
    public void generateArrays() {
        // Prepare
        Solution solution = new Solution();

        // Act
        int[] result = solution.generateArrays(2);

        // Check
        assertEquals("Unexpected size of result", 2, result.length);
    }

    /**
     * Getting exception to generate an array with a length less than 2.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldExceptionWhenLengthLessTwo() {
        // Act
        new Solution().generateArrays(1);
    }

    /**
     * Getting exception to generate an array with a length more than 100000.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldExceptionWhenLengthMoreOneHundredThousand() {
        // Act
        new Solution().generateArrays(100001);
    }
}
