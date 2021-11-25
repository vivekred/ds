package com.ds;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5,3,6,1,2,8};
        printArr(arr);
        bubbleSort(arr);
        System.out.println();
        printArr(arr);
    }

    static void bubbleSort(int []arr){
        for(int i = 0; i< arr.length; i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    static void printArr(int []arr){
        for(int i:arr){
            System.out.print(i + " ");
        }
    }
}
