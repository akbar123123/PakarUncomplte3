/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mhmmdadi21
 */
public class Delete extends Settings {
    
    /**
     * 
     * @param database
     * @param condition
     * @return
     * @throws SQLException 
     */
    public static Boolean All(String database, String[] condition) throws SQLException {
        String sql = "delete from "+database;
        Connection cn = (Connection) Settings.MyConfig();
        PreparedStatement pst = cn.prepareStatement(sql);
        return pst.execute();
    }
    
    /**
     * 
     * @param database
     * @param condition
     * @return
     * @throws SQLException 
     */
    public static Boolean Where(String database, String[] condition) throws SQLException {
        String sql = "delete from "+database+" where "+String.join("AND",condition);
        Connection cn = (Connection) Settings.MyConfig();
        PreparedStatement pst = cn.prepareStatement(sql);
        return pst.execute();
    }
    
}
