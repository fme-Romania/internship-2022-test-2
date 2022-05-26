/*______________________________________________________________________________________________________
 * 
 * Write a Java program that reads text from a file and prints out all the distinct words from the text.
 * 
 * The text contains only alpha-numerical characters and spaces, 
 * and words are delimited by one or more spaces.
 * _____________________________________________________________________________________________________
 * 
 * 
 * Example:
 * 
 *______________________________________________________________________________________________________
 *
 *  Input: test.in
 *      
 *       test1 test2 test3 test1 test test2 test2
 *       test1 test3 test1 test4 test test0
 *       
 *  Output:
 *      test4, test0
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________ 
 */

package fme.internship;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 * @author <Emanuel Bordeianu>
 * @email <emi.bordeianu.1999@gmail.com>
 * 
 */
public class Test2 {

    static void printDistinctWords(List<String> stringList){
        Map<String, Integer> map = new HashMap<>();

        for(String s: stringList){
            if(map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println(entry.getKey());
        }
    }

    public static void main(String[] args) {

        System.out.println("FME Internship - Test2");
        List<String> stringList = new ArrayList<>();

        try {
            File myObj = new File("test-internship-p2\\src\\test.in");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                //String data = myReader.nextLine();
                String data = myReader.next();
                //System.out.println(data);
                stringList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        printDistinctWords(stringList);

    }
}