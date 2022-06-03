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
public class Insert {
    /**
     * 
     * @param database
     * @param field
     * @param rowData
     * @throws SQLException 
     */
    public static Boolean Table(String database, String[] field, String[] rowData) throws SQLException{
        Connection cn = (Connection) Settings.MyConfig();
         String sql = "insert into "+database+" ("+String.join(" , ",field)+") values ('"+String.join("','",rowData)+"')";
            PreparedStatement pst = cn.prepareStatement(sql);
            System.out.println(sql);
            return pst.execute();
    }
}
