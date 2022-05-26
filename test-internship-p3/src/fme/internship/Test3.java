/*______________________________________________________________________________________________________
 * 
 * Write a Java program that reads a file containing on each line a geometric shape and its properties
 * in the following format:
 * 
 * Name : property1=value, property2=value, …
 * 
 * Shapes are limited to Circle, Square, Rectangle, Triangle.
 * 
 * Create 2 files area.out and perimeter.out, respectively, and write all the shapes
 * 
 *  - In area.out: in descending order by their area, in the format:
 *      Name: { property1=value, property2=value, ... , area = value }
 *      
 *  - In perimeter.out: in ascending order by their perimeter/circumference, in the format:
 *      Name: { property1=value, property2=value, ... , area = value }
 * 
 * Formulas:
 * 
 *  |===========|===============================|=======================|
 *  |Shape      |Area                           |Perimeter/Circumference|
 *  |===========|===============================|=======================|
 *  |Circle     |PI*r^2                         |2*PI*r                 |
 *  |===========|===============================|=======================|
 *  |Square     |length^2                       |4*length               |
 *  |===========|===============================|=======================|
 *  |Rectangle  |length*width                   |2*(length+width)       |         
 *  |===========|===============================|=======================|
 *  |Triangle   |sqrt(s*(s-a)*(s-b)*s(s-c))     |a+b+c                  |
 *  |           |   where s = (a+b+c)/2         |                       |
 *  |===========|===============================|=======================|
 * _____________________________________________________________________________________________________
 * 
 * 
 * Example:
 * 
 *______________________________________________________________________________________________________
 *
 *  Input: 
 *  
 *  shapes.in
 *      
 *      Circle : r=2
 *      Square : length=4
 *      Rectangle : length=3, width=4
 *      Circle : r=3
 *      Square : length=5
 *      Square : length=3
 *      Triangle: a=3, b=4, c=5
 *       
 *  Output:
 *  
 *  area.out
 *      
 *      Circle: { r=3, area=28.27 }
 *      Square: { length=5, area=25 }
 *      Square: { length=4, area=16 }
 *      Circle: { r=2, area=12.56 }
 *      Rectangle: { length=3, width=4, area=12 }
 *      Square: { length=3, area=9 }
 *      Triangle: { a=3, b=4, c=5, area=6 }
 *      
 *  perimeter.out
 *  
 *      Square: { length=3, perimeter=12 }
 *      Triangle: { a=3, b=4, c=5, perimeter=12 }
 *      Circle: { r=2, perimeter=12.56 }
 *      Rectangle: { length=3, width=4, perimeter=14 }
 *      Square: { length=4, perimeter=16 }
 *      Circle: { r=3, perimeter=18.84 }
 *      Square: { length=4, perimeter=20 }   
 *       
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________ 
 */

package fme.internship;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 
 * @author <Emanuel Bordeianu>
 * @email <emi.bordeianu.1999@gmail.com>
 * 
 */
public class Test3 {

    static double computeArea(String shape, int[] arr){
        if(shape.equals("Circle"))
            return arr[0] * arr[0] * Math.PI;
        else if(shape.equals("Square"))
            return 4 * arr[0];
        else if(shape.equals("Rectange"))
            return 2 * (arr[0] + arr[1]);
        else if(shape.equals("Triangle")){
            double s = (arr[0] + arr[1] + arr[2]) / 2;
            double rez = Math.sqrt(s*(s-arr[0])*(s-arr[1])*s*(s-arr[2]));
            return rez;
        }

        return -1;
    }

    static double computePerimeter(String shape, int[] arr){
        if(shape.equals("Circle"))
            return 2 * arr[0] * Math.PI;
        else if(shape.equals("Square"))
            return arr[0] * arr[0];
        else if(shape.equals("Rectange"))
            return arr[0] * arr[1];
        else if(shape.equals("Triangle")){
            return arr[0] + arr[1] + arr[2];
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println("FME Internship - Test3");
        List<String> stringList = new ArrayList<>();
//        Map<String, List<Integer>> map = new HashMap<>();

        List<String> shapes = new ArrayList<>();
        List<List<Integer>> lens = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        try {
            File myObj = new File("test-internship-p3\\src\\shapes.in");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                j = 0;
                String data = myReader.nextLine();
//                String data = myReader.next();
                stringList.add(data);
                try{
                    String s[] = data.split(" ");
                    for (String ss: s){
                        System.out.println("ss => " + ss);
                        if (ss.equals("Circle") || ss.equals("Triangle") || ss.equals("Rectangle") || ss.equals("Square")){
                            shapes.add(ss);
                        }
                        String[] s1 = ss.split("=");
                        for (String ss2: s1){
                            int a = 0;
                            try {
                                a = Integer.parseInt(ss2);
                            }catch (Exception e){
                                //System.out.println("NUUU");
                            }
                            System.out.println("a = " + a);
                        }
                    }

                }catch (Exception e){
                    //System.out.println("NU");
                }

                i++;
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        System.out.println("\n\nAfisare shapes:");
        for (int ii = 0; i<shapes.size(); ii++){
            System.out.println(shapes.get(ii));
        }


        try {
            FileWriter myWriter = new FileWriter("test-internship-p3\\src\\area.out");
            myWriter.write("Ceva");
            myWriter.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}