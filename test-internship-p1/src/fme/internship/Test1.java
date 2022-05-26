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
import java.util.Map;

/**
 * 
 * @author <Emanuel Bordeianu>
 * @email <emi.bordeianu.1999@gmail.com>
 * 
 */
public class Test1 {

    static int returnFirstElemThatOccursKTimes(int A[], int N, int K){
        Map<Integer, Integer> singletonElements = new HashMap<>();
        for(int i = 0; i<N; i++){
            // verif daca NU contine elementul
            if(singletonElements.get(A[i]) == null){
                singletonElements.put(A[i], 1);
            }
            // daca il are, incrementam valoarea cu 1
            else {
                singletonElements.put(A[i], singletonElements.get(A[i]) + 1);
            }
            // daca a ajuns egal cu K, returnam
            if(singletonElements.get(A[i]) == K)
                return A[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("FME Internship - Test1");

        int A[] = {1, 7, 4, 3, 4, 8, 7};
        int N = A.length;
        int K = 2;
        System.out.println(returnFirstElemThatOccursKTimes(A, N, K));

    }
}