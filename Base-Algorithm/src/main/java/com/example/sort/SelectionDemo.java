package com.example.sort;

/**
 * 选择排序
 */
public class SelectionDemo {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 7, 1, 9, 3, 5};
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
            }
            swap(array, i, minPos);
            System.out.println("经过第:" + i + "次循环之后的内容");
            print(array);
        }
    }

    static void swap(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
