package com.ds;

public class Main {
    static String items[] = {"NehaSBIDeposits:1106000", "NehaSBICash:38000", "NehaNikhilOutstanding:200000",
            "NehaMiLOutstanding:50000",
            "VivekCams:1500000", "VivekKarvy:2200000", "VivekHDFC:850000", "VivekEQPlus:300000",
    "DecSal:150000", "Gratuity:550000", "PF:4000000",};/*,
            "FY2022:1800000", "BNS:190000",

            "House:8000000", "Car:360000", "Gold:1800000"};

*/
    public static void main(String[] args) {
        printStats();
    }

    static void printStats() {
        int total = 0;
        for (String str : items) {
            String arr[] = str.split(":");
            System.out.println(arr[0] + " <->" + arr[1]);
            total += Integer.parseInt(arr[1]);
        }
        System.out.println("total:" + total);

        int year = 2021;

    }
}
