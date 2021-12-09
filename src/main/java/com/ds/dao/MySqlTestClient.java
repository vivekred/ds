package com.ds.dao;

import com.ds.domain.Pet;

import java.sql.Connection;
import java.sql.*;
import java.util.List;

public class MySqlTestClient {

    static Connection con = new DBUtil().getConnection();

    public static void main(String[] args) throws SQLException {
        testJDBCImpl();

    }
    static  void testJDBCImpl(){
        List<Pet> pets = new PetDaoJDBCImpl().listPet();

        for(Pet p : pets){
            System.out.println(p);
        }
    }
    static void testDBCon() throws  Exception{
        System.out.println("main starting");

        PreparedStatement ps = con.prepareStatement("select * from pet");

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

}
