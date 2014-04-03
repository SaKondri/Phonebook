package com.sakondri.view.center.login;

import com.sakondri.view.center.register.RegisterController;
import com.sakondri.view.controller.ViewController;
import com.sakondri.view.maingird.MainGrid;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginHome extends Application{
	private Label usernameLbl;
        private Stage stage;
	private TextField usernameTxt;
	private Label passwordLbl;
	private PasswordField passwordField;
	private Label rePasswordLbl;
	private PasswordField rePasswordField;
        private Button btnLogin;
        private HBox hBox;

    public LoginHome() {
            try {
                Stage stage = new Stage();
                start(stage);
               
            } catch (Exception ex) {
                Logger.getLogger(LoginHome.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
  
        
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridPane = new MainGrid();
                setStage(primaryStage);
		gridPane.add(getUsernameLbl(), 0, 1);
		gridPane.add(getUsernameTxt(), 1, 1);
		gridPane.add(getPasswordLbl(), 0, 2);
		gridPane.add(getPasswordField(), 1, 2);
		
                gethBox().getChildren().add(getBtnLogin());
                gridPane.add(gethBox(), 1, 3);
                Scene scene = new Scene(gridPane,305,170);
                getStage().setTitle(ViewController.getLanguage().getValue("login"));
                getStage().setScene(scene);
               
                getStage().show();
              
	}

    public Stage getStage() {
       if(stage == null){
           stage = new Stage();
       }
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
	
	
	public Label getUsernameLbl() {
		if (usernameLbl == null) {
			usernameLbl = new Label(ViewController.getLanguage().getValue(
					"username"));
		}
		return usernameLbl;
	}
        
        

	public Label getPasswordLbl() {
		if (passwordLbl == null) {
			passwordLbl = new Label(ViewController.getLanguage().getValue(
					"password"));
		}
		return passwordLbl;
	}

	public Label getRePasswordLbl() {
		if (rePasswordLbl == null) {
			rePasswordLbl = new Label(ViewController.getLanguage().getValue(
					"repassword"));
		}
		return rePasswordLbl;
	}

	public TextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new TextField();
		}
		return usernameTxt;
	}

	public void setUsernameTxt(TextField usernameTxt) {
		this.usernameTxt = usernameTxt;
	}

	public PasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new PasswordField();
		}
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public PasswordField getRePasswordField() {
		if (rePasswordField == null) {
			rePasswordField = new PasswordField();
		}
		return rePasswordField;
	}

	public void setRePasswordField(PasswordField rePasswordField) {
		this.rePasswordField = rePasswordField;
	}

	public void setUsernameLbl(Label usernameLbl) {
		this.usernameLbl = usernameLbl;
	}

	public void setPasswordLbl(Label passwordLbl) {
		this.passwordLbl = passwordLbl;
	}

	public void setRePasswordLbl(Label rePasswordLbl) {
		this.rePasswordLbl = rePasswordLbl;
	}

      public Button getBtnLogin() {
        if(btnLogin == null){
            btnLogin = new Button(ViewController.getLanguage().getValue("login"));
            btnLogin.setOnAction(e -> {
                LoginController.getLoginEvent().btnLogin();
            });
        }
        return btnLogin;
    }

    public HBox gethBox() {
       if(hBox == null){
           hBox = new HBox();
           hBox.setAlignment(Pos.BASELINE_LEFT);
       }
        return hBox;
    }
      
}