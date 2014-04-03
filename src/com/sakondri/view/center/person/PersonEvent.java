/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.view.center.person;

import com.sakondri.business.logic.IdController;
import com.sakondri.dao.GeneralDao;
import com.sakondri.model.Person;
import com.sakondri.view.center.register.RegisterController;
import com.sakondri.view.controller.ViewController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author sakondri
 */
public class PersonEvent {

   public void btnAddPerson(){
      PersonController.getPersonHome().getData().add(new Person(
                         PersonController.getPersonHome().getAddFirstName().getText(),
                        PersonController.getPersonHome().getAddLastName().getText(),
                        PersonController.getPersonHome().getAddEmail().getText()));
                Person person = new Person();
                person.setLoginId(IdController.getIdController().getId());
                person.setfName(PersonController.getPersonHome().getAddFirstName().getText());
                person.setlName(PersonController.getPersonHome().getAddLastName().getText());
                person.setpEmail(PersonController.getPersonHome().getAddEmail().getText());
                try {
                    GeneralDao.getGeneralDao().save(person);
                } catch (Exception ex) {
                    Logger.getLogger(PersonHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                PersonController.getPersonHome().getAddFirstName().clear();
                PersonController.getPersonHome().getAddLastName().clear();
                PersonController.getPersonHome().getAddEmail().clear();
   }
   
    
}
