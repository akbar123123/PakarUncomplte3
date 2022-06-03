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
public class Update {
    
    /**
     * 
     * @param database String Nama database
     * @param field String[] Kolom di database
     * @param rowData String[] yang akan di update
     * @param condition  Kondisi update
     * @return pst.execute;
     * @throws SQLException 
     */
   public static Boolean Where(String database, String[] rowData,String[] condition , String[]...field) throws SQLException{
        Connection cn = (Connection) Settings.MyConfig();
//         String sql = "insert into "+database+" ("+String.join(" , ",field)+") values ("+String.join(" , ",rowData)+")";
           String sql = "Update "+database+" set "+
                   String.join(" , ",rowData)+" "
                   +String.join(" , ",condition); 
           PreparedStatement pst = cn.prepareStatement(sql);
           return pst.execute();
    }
}
