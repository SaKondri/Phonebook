package com.sakondri.view.center.register;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import com.sakondri.dao.GeneralDao;
import com.sakondri.model.Login;
import com.sakondri.model.User;
import com.sakondri.model.UsernamePassword;
import com.sakondri.view.controller.ViewController;

public class RegisterEvent implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() instanceof Button){
			String name = ((Button)event.getSource()).getText();
			if(name.equals(ViewController.getLanguage().getValue(
				"register"))){
				
				Login login = new Login();
				User user = new User();
				UsernamePassword usernamePassword = new UsernamePassword();
				System.out.println(RegisterController.getRegisterHome().getfNameTxt().getText());
				user.setfName(RegisterController.getRegisterHome().getfNameTxt().getText());
				user.setlName(RegisterController.getRegisterHome().getlNameTxt().getText());
				user.setGender(RegisterController.getRegisterHome().getGenderNow());
				usernamePassword.setUsername(RegisterController.getRegisterHome().getUsernameTxt().getText());
				usernamePassword.setPassword(RegisterController.getRegisterHome().getPasswordTxt().getText());
				login.setUser(user);
				login.setUsernamePassword(usernamePassword);
				try {
					GeneralDao.getGeneralDao().save(login);
					RegisterController.getRegisterHome().getLblNotfication().setText(ViewController.getLanguage().getValue("Thank"));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					RegisterController.getRegisterHome().getLblNotfication().setText(ViewController.getLanguage().getValue("sorry"));
					if(e.getMessage() == null)
						RegisterController.getRegisterHome().getLblNotfication().setText(ViewController.getLanguage().getValue("Please"));
				}
			
			}
		}
	}
        

}
