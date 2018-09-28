package com.yhh.algorithm.day080928;

import java.util.Arrays;

public class ChoiceSort {

    public static void main(String[] args) {
        int[] arr = {10, 8, 77, 0, 7, 3};
        f(arr);
        g(arr);
    }

    public static void f(int[] array) {
        for(int i = 0 ; i < array.length-1 ; i++){
            int min = i;

            for(int j = i+1 ; j < array.length ; j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        //第 i轮排序的结果为
        System.out.println(Arrays.toString(array));
    }

    public static void g(int[] arr) {
        int len = arr.length;
        for (int i=0; i<len-1; i++) {
            int min = i;
            for (int j=i+1; j<len; j++) {
                if (arr[min]>arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
