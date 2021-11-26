package com.ds.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/scott?autoReconnect=true&useSSL=false";
    String user = "root", pass = "root";
    Connection con = null;
    static boolean init = false;

    public void init() throws  Exception{
        if(! init){
            System.out.println("In init method of DB Util");
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            init = true;

        }
    }

    public Connection getConnection(){
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
