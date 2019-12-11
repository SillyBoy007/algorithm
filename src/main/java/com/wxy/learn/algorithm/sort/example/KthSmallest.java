package com.wxy.learn.algorithm.sort.example;

public class KthSmallest {
    public static int getKthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int pivot = getPivot(arr, 0, arr.length - 1);

        while (pivot + 1 != k) {
            if (pivot + 1 < k) {
                pivot = getPivot(arr, pivot + 1, arr.length - 1);
            } else {
                pivot = getPivot(arr, 0, pivot - 1);
            }
        }
        return arr[pivot];
    }

    public static int getPivot(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low;
        for (int j = low;j<high;j++){
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr,i,high);
        return i;
    }

    private static void swap(int[] arr,int i ,int j){
        if (i==j){
            return;
        }
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {5,2,1,4,5,3};
        System.out.println(getKthSmallest(arr,1));
    }
}
