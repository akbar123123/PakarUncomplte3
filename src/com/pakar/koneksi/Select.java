/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.koneksi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mhmmdadi21
 */
public class Select extends Settings{
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
        java.sql.Connection con = (Connection) Settings.configDB();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();
        return rs;
    }
}
