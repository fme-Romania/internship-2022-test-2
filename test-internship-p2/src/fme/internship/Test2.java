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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Andrei Neagu
 * @email neaguandrei47@gmail.com
 */

public class Test2 {

    public static void printDistinct(String path) {
        String text;

        try {
            text = Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var words = new ArrayList<String>(List.of(text.split("\\W"))) ;
        var count = new HashMap<String, Integer>();

        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }

        count.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .forEach(word -> System.out.println(word.getKey()));
    }

    public static void main(String[] args) {
        printDistinct("test-internship-p2/src/test.in");
    }
}