package com.ds.dao;

import com.ds.domain.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDaoJDBCImpl implements PetDao {
    //Connection con = new DBUtil().getConnection();

    @Override
    public List<Pet> listPet() {
        Connection con = new DBUtil().getConnection();

        String sql = "select * from pet";

        PreparedStatement ps = null;
        List<Pet> pets = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();


        while (rs.next()){
            String name = rs.getString(1), owner = rs.getString(2), species = rs.getString(3);
            Pet pet = new Pet(name, owner, species);
            pets.add(pet);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
}
