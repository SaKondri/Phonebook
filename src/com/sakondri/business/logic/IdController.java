/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.business.logic;

/**
 *
 * @author sakondri
 */
public class IdController {
    private  Long id;
    private static IdController idController;

    private IdController() {
    }
    
    public static synchronized IdController getIdController() {
        if(idController == null){
            idController = new IdController();
        }
        return idController;
    }

    public  Long getId() {
        return id;
    }

    public  void setId(Long id) {
        this.id = id;
    }
    
    
}
