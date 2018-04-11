/**
 * Unique takes an array of integers sorted in increasing order, where one element appears once and all
 * other elements appear twice, and returns the unique element (the element that occurs once).
 * @author Vinh Nguyen (vnguye95@calpoly.edu)
 * @version CPE 349, Section 01, Spring 2018
 */

import java.util.*;
import java.io.*;


public class Unique {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(new File(args[0]));
        if(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.useDelimiter(", ");
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.close();
        System.out.println(unique(list));
    }

    public static int unique(ArrayList<Integer> list) {
        int i, uniq = list.get(0);
        int len = list.size();
        if(len == 1) {
            return uniq;
        }
        for(i = 0; i < len-1; i+=2) {
            if(i+1 == len) {
                uniq = list.get(i);
            }
            if(list.get(i) != list.get(i+1)) {
                uniq =  list.get(i);
            }
        }
        return uniq;
    }
}