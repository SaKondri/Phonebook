package com.sakondri.view.menubar.about;

import com.sakondri.view.controller.ViewController;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class AboutFilds {
	private Label about;
	private GridPane aboutGird;
	public Label getAboutDetails() {
		if(about == null){
			about = new Label();
			about.setFont(new Font("Verdana Blod" , 22));
			about.setText(ViewController.getLanguage().getValue("aboutDetails"));
		}
		return about;
	}
	public void setAbout(Label about) {
		this.about = about;
	}
	public GridPane getAboutGird() {
		if(aboutGird == null){
			aboutGird = new GridPane();
			aboutGird.add(getAboutDetails(), 1, 0);
		}
		return aboutGird;
	}
	
}
