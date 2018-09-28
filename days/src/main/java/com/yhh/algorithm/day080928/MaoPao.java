package com.yhh.algorithm.day080928;

import java.util.Arrays;

public class MaoPao {

    public static void main(String[] args) {
        int[] arr = {10, 8, 77, 0, 7, 3};
        new MaoPao().f(arr);
    }


    public void f(int[] arr) {
        int len = arr.length;
        for (int i=0; i<len-1; i++) {
            for (int j=0; j<len-1-i; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }



}
