/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.view.center.login;

/**
 *
 * @author sakondri
 */
public class LoginController {
    private static LoginEvent loginEvent;
    private static LoginHome loginHome;

    public static synchronized LoginEvent getLoginEvent() {
       if(loginEvent == null){
           loginEvent = new LoginEvent();
       }
        return loginEvent;
    }

    public static synchronized LoginHome getLoginHome() {
       if(loginHome == null){
           loginHome = new LoginHome();
       }
        return loginHome;
    }

    public static void setLoginHome(LoginHome loginHome) {
        LoginController.loginHome = loginHome;
    }
    
}
