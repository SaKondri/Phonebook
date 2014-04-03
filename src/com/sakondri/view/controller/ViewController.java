package com.sakondri.view.controller;

import com.sakondri.view.eventcontroller.MenuBarEventController;
import com.sakondri.view.home.Home;
import com.sakondri.view.home.HomeGrid;
import com.sakondri.view.language.Language;
import com.sakondri.view.menubar.MenuBar;
import com.sakondri.view.menubar.about.AboutFilds;

public class ViewController {
	private static Home home;
	private static Language language;
	private static MenuBarEventController eventController;
	private static AboutFilds aboutFilds;
	private static MenuBar menuBar;
	private static HomeGrid homeGrid;
	
	private ViewController() {
	}

	public synchronized static Home getHome() {
		if (home == null) {
			home = new Home();
		}
		return home;
	}

	public synchronized static Language getLanguage() {
		if (language == null) {
			language = new Language();
		}
		return language;
	}

	public synchronized static MenuBarEventController getMenuBarEventController() {
		if (eventController == null) {
			eventController = new MenuBarEventController();
		}
		return eventController;
	}
	public synchronized static AboutFilds getAboutFilds() {
		if(aboutFilds == null){
			aboutFilds = new AboutFilds();
		}
		return aboutFilds;
	}
	public synchronized static MenuBar getMenuBar() {
		if(menuBar == null){
			menuBar = new MenuBar();
		}
		return menuBar;
	}
	public static void setHome(Home home) {
		ViewController.home = home;
	}
	public synchronized static HomeGrid getHomeGrid() {
		if(homeGrid == null){
			homeGrid = new HomeGrid();
		}
		return homeGrid;
	}
	public static void setHomeGrid(HomeGrid homeGrid) {
		ViewController.homeGrid = homeGrid;
	}

    public static void setMenuBar(MenuBar menuBar) {
        ViewController.menuBar = menuBar;
    }
        
}
