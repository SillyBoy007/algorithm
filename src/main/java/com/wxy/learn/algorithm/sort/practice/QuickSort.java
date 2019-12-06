//package com.wxy.learn.algorithm.sort.practice;
//
//public class QuickSort {
//    public static void quickSort(int[] a, int n) {
//        quickSortInternally(a, 0, n - 1);
//    }
//
//    public static void quickSortInternally(int[] a, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//        // 获取分区点
//        int m = partition(a, low, high);
//
//        quickSortInternally(a, low, m);
//        quickSortInternally(a, m + 1, high);
//
//    }
//
//    public static int partition(int[] a, int low, int high) {
//        // 切分元素
//        int p = a[low];
//        // 下一个小于切分元素可插入的位置
//        int i = low;
//
//        for (int j = low; j < high; j++) {
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
