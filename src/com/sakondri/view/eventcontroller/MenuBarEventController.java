package com.sakondri.view.eventcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import com.sakondri.view.center.register.RegisterController;
import com.sakondri.view.center.register.RegisterHome;

public class MenuBarEventController implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() instanceof MenuItem) {
			String name = ((MenuItem) event.getSource()).getText();
			if (name.equals("Exit")) {

				System.exit(0);
			} else if (name.equals("About")) {
				try {

				} catch (Exception e) {

				}
			}
			else if (name.equals("Register")) {
				try {
					RegisterController.setRegisterHome(new RegisterHome());
					
				} catch (Exception e) {
				}
			}
		}
	}
}
