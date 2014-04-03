package com.sakondri.view.center.register;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.sakondri.view.controller.ViewController;
import com.sakondri.view.maingird.MainGrid;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterHome extends Application {
	private Label fName;
	private Label lName;
	private Button btnReg;
	private TextField fNameTxt;
	private TextField lNameTxt;
	private Label lblGender;
	private RadioButton rbMan;
	private RadioButton rmWoman;
	private ToggleGroup group;
	private String genderNow;
	private Label lblUsername;
	private Label lblPassword;
	private TextField usernameTxt;
	private PasswordField passwordTxt;
	private Label lblNotfication;
	@Override
	public void start(Stage primaryStage)  {
		GridPane grid = new MainGrid();
		grid.add(getfName(), 0, 1);
		grid.add(getfNameTxt(), 1, 1);
		grid.add(getlName(), 0, 2);
		grid.add(getlNameTxt(), 1, 2);
		grid.add(getLblGender(), 0, 3);
		HBox rbP = new HBox(3);
		rbP.getChildren().add(getRbMan());
		rbP.getChildren().add(getRmWoman());
		grid.add(rbP, 1, 3);
		grid.add(getLblUsername(), 0, 4);
		grid.add(getUsernameTxt(), 1, 4);
		grid.add(getLblPassword(), 0, 5);
		grid.add(getPasswordTxt(), 1, 5);
		HBox hbBtn = new HBox(3);
		hbBtn.setAlignment(Pos.BASELINE_LEFT);
		hbBtn.getChildren().add(getBtnReg());
		grid.add(hbBtn, 1, 6);
		grid.add(getLblNotfication(), 1, 7);
		getBtnReg().setOnAction(RegisterController.getRegisterEvent());
		Scene scene = new Scene(grid, 330, 270);
               
		primaryStage.setOnCloseRequest(e ->  {			
                    try {
                        stop();
                    } catch (Exception ex) {
                        Logger.getLogger(RegisterHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
		});
                primaryStage.setTitle(ViewController.getLanguage().getValue("register"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public RegisterHome() {
		Stage stage = new Stage();
		try {
			start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Label getfName() {
		if(fName == null){
			fName = new Label(ViewController.getLanguage().getValue("fName"));
		}
		return fName;
	}

	public Label getlName() {
		if(lName == null){
			lName = new Label(ViewController.getLanguage().getValue("lName"));
		}
		return lName;
	}

	public Button getBtnReg() {
		if(btnReg == null){
			btnReg = new  Button(ViewController.getLanguage().getValue(
					"register"));
		}
		return btnReg;
	}

	public TextField getfNameTxt() {
		if(fNameTxt == null){
			fNameTxt = new TextField();
		}
		return fNameTxt;
	}

	public TextField getlNameTxt() {
		if(lNameTxt == null){
			lNameTxt = new TextField();
		}
		return lNameTxt;
	}
	
	public RadioButton getRbMan() {
		if(rbMan == null){
			rbMan =new RadioButton(ViewController.getLanguage().getValue("man"));
			rbMan.setToggleGroup(getGroup());
			rbMan.setUserData("man");
		}
		return rbMan;
	}
	public RadioButton getRmWoman() {
		if(rmWoman == null){
			rmWoman =new RadioButton(ViewController.getLanguage().getValue("woman"));
			rmWoman.setToggleGroup(getGroup());
			rmWoman.setUserData("woman");
		}
		return rmWoman;
	}
	public Label getLblGender() {
		if(lblGender == null){
			lblGender = new Label(ViewController.getLanguage().getValue("gender"));
		}
		return lblGender;
	}
	public ToggleGroup getGroup() {
		if(group == null){
			group = new ToggleGroup();
			group.selectedToggleProperty().addListener(e -> {				
					setGenderNow(group.getSelectedToggle().getUserData().toString());
                                        });
                }
		return group;
	}
	public String getGenderNow() {
		return genderNow;
	}
	public void setGenderNow(String genderNow) {
		this.genderNow = genderNow;
	}

	public Label getLblUsername() {
		if(lblUsername == null){
			lblUsername = new Label(ViewController.getLanguage().getValue("username"));
		}
		return lblUsername;
	}

	public void setLblUsername(Label lblUsername) {
		this.lblUsername = lblUsername;
	}

	public Label getLblPassword() {
		if(lblPassword == null){
			lblPassword = new Label(ViewController.getLanguage().getValue("password"));
		}
		return lblPassword;
	}

	public void setLblPassword(Label lblPassword) {
		this.lblPassword = lblPassword;
	}

	public TextField getUsernameTxt() {
		if(usernameTxt == null){
			usernameTxt = new TextField();
		}
		return usernameTxt;
	}

	public void setUsernameTxt(TextField usernameTxt) {
		this.usernameTxt = usernameTxt;
	}

	public PasswordField getPasswordTxt() {
		if(passwordTxt == null){
			passwordTxt = new PasswordField();
		}
		return passwordTxt;
	}

	public void setPasswordTxt(PasswordField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}
	public Label getLblNotfication() {
		if(lblNotfication == null){
			lblNotfication = new Label();
			
		}
		return lblNotfication;
	}
	public void setLblNotfication(Label lblNotfication) {
		this.lblNotfication = lblNotfication;
	}
}
