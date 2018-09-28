package com.yhh.algorithm.day080928;

public class BinarySearch {


    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 使用递归的二分查找
     */
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;
        if(arr[middle] > key){
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = recursionBinarySearch(arr, 99, 0, arr.length-1);
        System.out.println(i);
    }
}
