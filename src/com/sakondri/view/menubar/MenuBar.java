package com.sakondri.view.menubar;

import com.sakondri.view.center.login.LoginController;
import com.sakondri.view.center.login.LoginHome;
import com.sakondri.view.center.person.PersonController;
import com.sakondri.view.center.person.PersonHome;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

import com.sakondri.view.controller.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuBar {
	private javafx.scene.control.MenuBar menuBar;
	private Menu file;
	private MenuItem register;
        private MenuItem login;
	private MenuItem exit;
	private Menu help;
	private MenuItem about;
        private Menu person;
        private MenuItem addPerson;
	public javafx.scene.control.MenuBar getMenuBar() {
		if(menuBar == null){
			menuBar = new javafx.scene.control.MenuBar();
			menuBar.getMenus().add(getFile());
                        menuBar.getMenus().add(getPerson());
			menuBar.getMenus().add(getHelp());
                         
		}
              
		return menuBar;
	}
	public void setMenuBar(javafx.scene.control.MenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public Menu getFile() {
		if(file == null){
			file = new Menu(ViewController.getLanguage().getValue("file"));
			file.getItems().add(getRegister());
                        file.getItems().add(getLogin());
			file.getItems().add(new SeparatorMenuItem());
			file.getItems().add(getExit());
		}
		return file;
	}

	public void setFile(Menu file) {
		this.file = file;
	}
	public MenuItem getRegister() {
		if(register == null){
			register = new MenuItem(ViewController.getLanguage().getValue("register"));
			register.setOnAction(ViewController.getMenuBarEventController());
			register.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
		}
		return register;
	}
	public void setAddPerson(MenuItem addPerson) {
		this.register = addPerson;
	}
	public MenuItem getExit() {
		if(exit == null){
			exit = new MenuItem(ViewController.getLanguage().getValue("exit"));
			exit.setOnAction(ViewController.getMenuBarEventController());
			exit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		}
		return exit;
	}
	public void setExit(MenuItem exit) {
		this.exit = exit;
	}
	public Menu getHelp() {
		if(help == null){
			help = new Menu(ViewController.getLanguage().getValue("help"));
			help.getItems().add(getAbout());
		}
		return help;
	}
	public MenuItem getAbout() {
		if(about == null){
			about = new MenuItem(ViewController.getLanguage().getValue("about"));
			about.setOnAction(ViewController.getMenuBarEventController());
		}
		return about;
	}

    public MenuItem getLogin() {
      if(login == null){
          login = new MenuItem(ViewController.getLanguage().getValue("login"));
          login.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
          login.setOnAction(e ->  {
             LoginController.setLoginHome(new LoginHome());
         });
         
      }
        return login;
    }

    public Menu getPerson() {
        if(person == null){
            person = new Menu(ViewController.getLanguage().getValue("person"));
            person.getItems().add(getAddPerson());
            person.setVisible(false);
        }
        return person;
    }

    public MenuItem getAddPerson() {
       if(addPerson == null){
           addPerson = new MenuItem(ViewController.getLanguage().getValue("addPerson"));
           addPerson.setOnAction(e -> {PersonController.setPersonHome(new PersonHome());});
       }
        return addPerson;
    }

    public void setPerson(Menu person) {
        this.person = person;
    }
     
}
