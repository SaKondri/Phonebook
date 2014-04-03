package com.sakondri.view.home;

import javafx.scene.layout.GridPane;

public class HomeGrid {
	private GridPane homeGirid;
	public GridPane getHomeGirid() {
		if(homeGirid == null){
			homeGirid = new GridPane();
		}
		return homeGirid;
	}
	public void setHomeGirid(GridPane homeGirid) {
		this.homeGirid = homeGirid;
	}
}
