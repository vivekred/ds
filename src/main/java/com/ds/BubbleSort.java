package com.ds;

public class BubbleSort {
    static int arr[] = new Util().arr;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Bubble sort..");
        Util.printArr(arr);
        bubbleSort(arr);
        System.out.println();
        Util.printArr(arr);
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


}
