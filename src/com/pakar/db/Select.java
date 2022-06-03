/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.db;

import java.sql.*;

/**
 *
 * @author mhmmdadi21
 */
public class Select extends Settings {

    /**
     *
     * @param database
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet all(String database) throws SQLException {
        char column = '*';
        String sql = "Select " + column + " from " + database;
        java.sql.Connection con = (Connection) Settings.MyConfig();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();
        return rs;
    }
    
    /**
     * 
     * @param column
     * @param database
     * @return
     * @throws SQLException 
     */

    public ResultSet getColumn(String[] column, String database) throws SQLException {
        String ListColumn = String.join(",", column);
        String sql = "Select " + ListColumn + " from " + database;
        java.sql.Connection con = (Connection) Settings.MyConfig();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();
        return rs;
    }

    /**
     * 
     * @param database
     * @param condition
     * @return
     * @throws SQLException 
     */
    public ResultSet getWhere(String database, String[] condition) throws SQLException {
        String ListCondition = String.join(" AND ", condition);
        String sql = "Select * from " + database + " where " + ListCondition;
        java.sql.Connection con = (Connection) Settings.MyConfig();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();
        return rs;
    }

    public static void main(String[] args) {
        String[] condition = {"code = 'a1'","code = 'a2'"};
        System.out.println("select * from db where "+String.join(" AND ", condition));
    }
}
