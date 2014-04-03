package com.sakondri.view.maingird;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;


public class MainGrid extends GridPane{
	public MainGrid() {
		super.setAlignment(Pos.TOP_CENTER);
		super.setHgap(10);
		super.setVgap(10);
		super.setPadding(new Insets(25, 25, 25, 25));
	}
	
}
