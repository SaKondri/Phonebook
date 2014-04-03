/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.view.center.person;

/**
 *
 * @author sakondri
 */
public class PersonController {
    private static PersonHome personHome;
    private static PersonEvent personEvent;

    public static synchronized PersonEvent getPersonEvent() {
       if(personEvent == null){
           personEvent = new PersonEvent();
       }
        return personEvent;
    }

    public static synchronized PersonHome getPersonHome() {
       if(personHome == null){
           personHome = new PersonHome();
       }
        return personHome;
    }

    public static void setPersonEvent(PersonEvent personEvent) {
        PersonController.personEvent = personEvent;
    }

    public static void setPersonHome(PersonHome personHome) {
        PersonController.personHome = personHome;
    }
    
    
}
