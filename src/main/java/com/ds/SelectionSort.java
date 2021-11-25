package com.ds;


public class SelectionSort {
    static int arr[] = new Util().arr;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Selection sort..");
        Util.printArr(arr);
        selSort(arr);
        System.out.println();
        Util.printArr(arr);
    }

    static void selSort(int arr[]){
        for(int i=0; i<arr.length;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min =j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
