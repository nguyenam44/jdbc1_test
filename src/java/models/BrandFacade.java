/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 */
public class BrandFacade extends AbstractFacade<Brand> {

    @Override
    protected List<Brand> readAll(Connection con) throws SQLException {
        List<Brand> list = new ArrayList<>();
        String sql = "select * from brand";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Brand brand = new Brand(rs.getString(1), rs.getString(2));
            list.add(brand);
        }
        return list;
    }

    @Override
    protected void create(Connection con, Brand brand) throws SQLException {
        String sql = "insert into Brand values (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, brand.getId());
        ps.setString(2, brand.getName());
        ps.executeUpdate();
    }

    @Override
    protected Brand read(Connection con, Object id) throws SQLException {
        Brand brand = null;
        String sql = "select * from Brand where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet rs = stm.executeQuery();
        //Loading data into the list            
        if (rs.next()) {
            brand = new Brand();
            brand.setId(rs.getString("id"));
            brand.setName(rs.getString("name"));
        }
        return brand;
    }

    @Override
    protected void update(Connection con, Brand brand) throws SQLException {
        String sql = "UPDATE [dbo].[Brand]\n"
                + "   SET  [Name] = ?\n"
                + " WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, brand.getName());
        ps.setString(2, brand.getId());
        ps.executeUpdate();
    }

    @Override
    protected void delete(Connection con, Object id) throws SQLException {
        String sql = "delete from Brand where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id.toString());
        ps.executeUpdate();
    }

//    public static void main(String[] args) {
//        BrandFacade bf = new BrandFacade();
//        Brand brand = new Brand("003", "E brand");
//        bf.update(brand);
//
//    }

}
