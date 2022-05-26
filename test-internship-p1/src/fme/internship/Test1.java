/*______________________________________________________________________________________________________
 *
 * Write a Java program that reads an array of N positive integers from the console
 * and prints the first element that occurs at least K number of times.
 * If there are no elements that occur at least K times, print out -1.
 * _____________________________________________________________________________________________________
 *
 *
 * Example:
 *
 *______________________________________________________________________________________________________
 *
 *  Input:
 *      N = 7, K = 2
 *      A[7] = {1, 7, 4, 3, 4, 8, 7}
 *  Output:
 *      4
 *  Explanation:
 *      Both 7 and 4 occur 2 times, but 4 is the first element that occurs 2 times.
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________
 */

package fme.internship;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Andrei Neagu
 * @email neaguandrei47@gmail.com
 */
public class Test1 {

    static void printDistinct(int arr[], int n, int k) {
        var count = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int occurrences = 0;

            if (count.get(arr[i]) != null) {
                occurrences = count.get(arr[i]);
            }

            count.put(arr[i], occurrences + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(arr[i]) == k) {
                System.out.println(arr[i]);
                return;
            }
        }

        System.out.println("-1");
    }

    // Driver program
    public static void main(String[] args) {
        int A[] = {1, 7, 4, 3, 4, 8, 7};
        int N = 7;
        int K = 2;

        printDistinct(A, N, K);

    }
}