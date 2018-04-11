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
        System.out.println(unique(list, 0, list.size()-1));
    }

    public static int unique(ArrayList<Integer> list, int min, int max) {
        int midpt_index = (min+max)/2;
        int midpt = list.get(midpt_index);
        int next;
        int prev;
        if(list.size() == 1) {
            return list.get(midpt_index);
        }
        next = list.get(midpt_index+1);
        prev = list.get(midpt_index-1);
        if(midpt != next && midpt != prev) {
            return list.get(midpt_index);
        }
        if(midpt_index % 2 == 0) {//midpt_index is even
            if(midpt == next) {
                min = midpt_index+1;
            }
            else {
                max = midpt_index-2;
            }
        }
        else {//midpt_index is odd
            if(midpt == next) {
                max = midpt_index-1;
            }
            else {
                min = midpt_index+1;
            }
        }
        return unique(list, min, max);
    }
}