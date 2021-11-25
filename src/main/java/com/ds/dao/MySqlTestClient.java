package com.ds.dao;

import java.sql.Connection;
import java.sql.*;

public class MySqlTestClient {

    static Connection con = new DBUtil().getConnection();

    public static void main(String[] args) throws SQLException {
        System.out.println("main starting");

        PreparedStatement ps = con.prepareStatement("select * from pet");

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }

    }

}
