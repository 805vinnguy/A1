/**
 * Computes the runtime of Selection Sort.
 * 
 * @author Vinh Nguyen (vnguye95@calpoly.edu)
 * @version CPE 349, Section 01, Spring 2018
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class SelectionSort {
    public static void main(String[] args) {
        int size = 10000;
        int[] test;
        long t_before;
        long t_after;
        for(; size < 20000; size+=20) {
            test = rnglist(size);
            t_before = System.currentTimeMillis();
            selectsort(test);
            t_after = System.currentTimeMillis();
            System.out.println(t_after - t_before);
        }
        
    }

    public static void selectsort(int[] arr) {
        int len = arr.length;
        int i, min;
        int j = 0;
        int end = 0;
        
        for(end = 0; end < len-1; end++) {
            min = arr[end];
            for(i = end; i < len; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                    j = i;
                }
            }
            arr[j] = arr[end];
            arr[end] = min;
        }
    }

    public static int[] rnglist(int length) {
        Random rng = new Random();
        int[] arr = new int[length];
        int i;
        for(i = 0; i < length-1; i+=2) {
            arr[i] = rng.nextInt(10000);
            arr[i+1] = -1 * rng.nextInt(10000);
        }
        return arr;
    }

    public static void printarr(int[] arr) {
        int i;
        int len = arr.length;
        for(i = 0; i < len; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
    }
}