package com.ds.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Sample CSV header and data rows
Month,Open,High,Low,Close
December-1990,,,,1048.29,
January-1991,1027.38,1034.30,947.14,982.32,

 */
public class MySQLLoadFromCSV {
    private String csvFile;
    private Connection con = new DBUtil().getConnection();

    public MySQLLoadFromCSV(String csvFile) {
        this.csvFile = csvFile;
    }

    public static void main(String[] args) throws Exception {
       MySQLLoadFromCSV inst = new MySQLLoadFromCSV("sen.csv");
        List<Sensex> list = inst.listRecords();
        //
        for(Sensex s: list){
            System.out.println(s.insertSQL());
        }
        inst.saveRecords(list);
        System.out.println("INSERT UPDATE complete");
    }

    public void saveRecords(List<Sensex> list) throws  Exception{
        Connection con = new DBUtil().getConnection();
        Statement stmt = con.createStatement();
        for(Sensex record:list){
            String sql = record.insertSQL();


            stmt.executeUpdate(sql);
        }
        stmt.close();;
        con.close();
    }
    public List<Sensex> listRecords() throws FileNotFoundException {
        List<Sensex> list = new ArrayList<Sensex>();
        Scanner sc = new Scanner(new File(csvFile));
        // skip the header record
        sc.nextLine();

        while (sc.hasNext()){
            try {
                String str = sc.nextLine();
                Sensex sensex = new Sensex(str);
                System.out.println(sensex);
                list.add(sensex);
            }catch (NumberFormatException ex){
                System.err.println("BAD RECORD:" + ex.getMessage());
            }

        }
        return list;
    }

}

class Sensex{
    private String month;
    private double open, high, low, close;

    public Sensex(String record){
        String data[] = record.split(",");
        month = data[0].isEmpty()?null:data[0];
        open = data[1] == null?null:Double.parseDouble(data[1]);
        high = data[2]== null?null:Double.parseDouble(data[2]);
        low = data[3]== null?null:Double.parseDouble(data[3]);
        close = data[4]== null?null:Double.parseDouble(data[4]);
    }

    @Override
    public String toString() {
        return "Sensex{" +
                "month='" + month + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                '}';
    }

    public String insertSQL(){
        String str = "INSERT into SENSEX values ('" + month + "'," + open + "," + high + "," + low + "," + close + ")";
        return str;
    }
}