/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

/**
 *
 * @author SULTHAN
 */
class UserSession {
    public static String userLogin;
    public static String userLogin2;

    public static void setUserLogin(String userLogin) {
        UserSession.userLogin = userLogin;
    }
    
    public static String getUserLogin() {
        return userLogin;
    }
    public static void setUserLogin2(String userLogin2) {
        UserSession.userLogin2 = userLogin2;
    }
    
    public static String getUserLogin2() {
        return userLogin2;
    }
}
