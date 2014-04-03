package com.sakondri.view.home;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import com.sakondri.view.controller.ViewController;

public class Home{
	private VBox vBox;
	private Scene scene;
	
	public VBox getvBox() {
		if(vBox == null){
			vBox = new VBox();
			vBox.getChildren().add(ViewController.getMenuBar().getMenuBar());
			vBox.getChildren().add(ViewController.getHomeGrid().getHomeGirid());
		}
		return vBox;
	}
	public Scene getScene() {
		if(scene == null){
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			scene = new Scene(getvBox(),dimension.width,dimension.height);
			scene.setFill(Color.OLDLACE);
		}
		return scene;
	}
	public Scene getScene(VBox vBox) {
		if(scene == null){
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			scene = new Scene(vBox,dimension.height,dimension.width);
			scene.setFill(Color.OLDLACE);
		}
		return scene;
	}
	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
