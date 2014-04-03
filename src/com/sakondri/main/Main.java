package com.sakondri.main;

import com.sakondri.dao.GeneralDao;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.sakondri.view.controller.ViewController;

public class Main extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(ViewController.getLanguage().getValue("title"));
		stage.setScene(ViewController.getHome().getScene());
		stage.show();
                GeneralDao.getGeneralDao();
	}
	public static void main(String[] args) {
		launch(args);
                
	}
	
}
