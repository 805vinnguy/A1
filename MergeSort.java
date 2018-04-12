/**
 * Computes the runtime of MergeSort.
 * 
 * @author Vinh Nguyen (vnguye95@calpoly.edu)
 * @version CPE 349, Section 01, Spring 2018
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class MergeSort {
    public static void main(String[] args) {
        int size = 10000;
        int[] test;
        long t_before;
        long t_after;
        for(; size < 20001; size+=20) {
            test = rnglist(size);
            t_before = System.currentTimeMillis();
            test = mergesort(test);
            t_after = System.currentTimeMillis();
            System.out.println(t_after - t_before);
        }
    }

    public static int[] mergesort(int[] arr) {
        int len = arr.length;
        int[] arr1, arr2;
        int i;
        int j = 0;
        int k = 0;
        if(len <= 1) {
            return arr;
        }
        arr1 = new int[len/2];
        arr2 = new int[len - len/2];
        for(i = 0; i < len; i++) {
            if(i < len/2) {
                arr1[j] = arr[i];
                j++;
            }
            else {
                arr2[k] = arr[i];
                k++;
            }
        }
        arr1 = mergesort(arr1);
        arr2 = mergesort(arr2);
        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1 + len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while((i < len1) && (j < len2)) {
            if(arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            }
            else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < len1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j < len2) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
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