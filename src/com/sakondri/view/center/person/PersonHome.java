/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.view.center.person;

import com.sakondri.business.logic.IdController;
import com.sakondri.dao.GeneralDao;
import com.sakondri.model.Person;
import com.sakondri.view.center.register.RegisterHome;
import com.sakondri.view.controller.ViewController;
import com.sakondri.view.maingird.MainGrid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author sakondri
 */
public class PersonHome extends Application{
       private TableView<Person> table;
       private TableColumn lastNameCol ;
        private TableColumn firstNameCol;
      private   TableColumn emailCol;
        private  ObservableList<Person> data;
        private HBox hb ;
     private TextField addFirstName ;
     private TextField addLastName ;
     private TextField addEmail;
     private Button addPerson;
    public TableColumn getEmailCol() {
       if(emailCol == null){
           emailCol =  new TableColumn("Email");
            emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                }
            }
        );

       
       }
        return emailCol;
    }
      
    public TableColumn getFirstNameCol() {
        if(firstNameCol == null){
            firstNameCol = new TableColumn("First Name");
            firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setFirstName(t.getNewValue());
                }
            }
        );
          
        }
        return firstNameCol;
    }
        
    public TableColumn getLastNameCol() {
        if(lastNameCol == null){
            lastNameCol = new TableColumn(ViewController.getLanguage().getValue("lName"));
             lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    Person person = (Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow());
                    System.out.println(person.getId());
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                    System.out.println(t);
                }
            }
        );
        }
        return lastNameCol;
    }
       
       
    public TableView<Person> getTable() {
      if(table == null){
          table = new TableView<>();
           table.setItems(getData());
        table.getColumns().addAll(getFirstNameCol(), getLastNameCol(), getEmailCol());
        table.setEditable(true);
      }
        return table;
    }
     
   
         

    public ObservableList<Person> getData() {
        if(data == null){
            
             Map<String , Object> params = new HashMap<>();
              params.put("id",IdController.getIdController().getId());
             List<Person> people = GeneralDao.getGeneralDao().selectList("Person.selectById", params);
             List<Person> persons = new ArrayList<>();
             people.forEach(po -> persons.add(new Person(po.getfName(),po.getlName(), po.getpEmail())));
             data =  FXCollections.observableArrayList(persons);
        }
        return data;
    }
       
    
    public TextField getAddFirstName() {
        if(addFirstName == null){
            addFirstName = new TextField();
            addFirstName.setPromptText("First Name");
             addFirstName.setMaxWidth(getFirstNameCol().getPrefWidth());
             
        }
        return addFirstName;
    }

    public TextField getAddLastName() {
        if(addLastName == null){
            addLastName = new TextField();
            addLastName.setPromptText("Last Name");
            addLastName.setMaxWidth(getLastNameCol().getPrefWidth());
        }
        return addLastName;
    }

    public TextField getAddEmail() {
        if(addEmail == null){
            addEmail = new TextField();
            addEmail.setPromptText("Email");
          addEmail.setMaxWidth(getEmailCol().getPrefWidth());
                
        }
        return addEmail;
    }

       
    public Button getAddPerson() {
        if(addPerson == null){
            addPerson = new Button(ViewController.getLanguage().getValue("addPerson"));
             addPerson.setOnAction(e->{PersonController.getPersonEvent().btnAddPerson();});
        }
        
        return addPerson;
    }
     
    public HBox getHb() {
       if(hb == null){
           hb = new HBox();
        hb.getChildren().addAll(getAddFirstName(), getAddLastName(), getAddEmail(), getAddPerson());
        hb.setSpacing(3);
       }
        return hb;
    }
    
 
   
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(getTable(), getHb());
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
     public PersonHome() {
        try {
            Stage stage = new Stage();
           
            start(stage);
        } catch (Exception ex) {
            Logger.getLogger(PersonHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
