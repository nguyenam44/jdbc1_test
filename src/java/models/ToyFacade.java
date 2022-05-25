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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 */
public class ToyFacade extends AbstractFacade<Toy>{

    @Override
    protected List<Toy> readAll(Connection con) throws SQLException {
        List<Toy> list = new ArrayList<>();        
        //Creating and executing JDBC statements
        String sql = "select * from Toy";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        //Loading data into the list            
        while (rs.next()) {
            Toy toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getBigDecimal("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrandId(rs.getString("brand"));
            list.add(toy);
        }
        return list;
    }

    @Override
    protected void create(Connection con, Toy toy) throws SQLException {
        String sql = "insert into Toy values(?, ?, ?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setBigDecimal(3, toy.getPrice()); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, df.format(toy.getExpDate()));
        stm.setString(5, toy.getBrandId());        
        stm.executeUpdate();
    }

    @Override
    protected Toy read(Connection con, Object id) throws SQLException {
        Toy toy = null;
        String sql = "select * from Toy where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet rs = stm.executeQuery();
        //Loading data into the list            
        if (rs.next()) {
            toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getBigDecimal("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrandId(rs.getString("brand"));
        }
        return toy;
    }

    @Override
    protected void update(Connection con, Toy toy) throws SQLException {
        String sql = "update Toy set name=?, price=?, expDate=?, brand=? where id=?";
        PreparedStatement stm = con.prepareStatement(sql);        
        stm.setString(1, toy.getName());
        stm.setBigDecimal(2, toy.getPrice()); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, df.format(toy.getExpDate()));
        stm.setString(4, toy.getBrandId()); 
        stm.setString(5, toy.getId());
        stm.executeUpdate();
    }

    @Override
    protected void delete(Connection con, Object id) throws SQLException {
        String sql = "delete from Toy where id=?";
        PreparedStatement stm = con.prepareStatement(sql);         
        stm.setString(1, id.toString());
        stm.executeUpdate();
    }
    
}
