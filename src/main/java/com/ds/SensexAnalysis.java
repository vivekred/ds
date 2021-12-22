package com.ds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SensexAnalysis {
    static String inputFile = "d:/sensex.csv";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(inputFile));
        double inv = 0.0;
        int units = 0;
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(str);
            String arr[] = str.split(",");
            String month = arr[0], index = arr[4];
            double sensex = Double.parseDouble(index);
            double nav = sensex * 100;
           // System.out.println(month + " " + index + " " + nav) ;

            inv += sensex;
            units ++;

        }
        System.out.println("no of sips" + units);
        System.out.println( "INV" + inv);
        System.out.println("NAV" + (58000 * units));
    }

}
