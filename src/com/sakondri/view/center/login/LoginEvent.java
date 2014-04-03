package com.sakondri.view.center.login;


import com.sakondri.business.logic.IdController;
import com.sakondri.dao.GeneralDao;
import com.sakondri.model.Login;
import com.sakondri.view.controller.ViewController;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoginEvent {
  
    public void btnLogin(){
        
        Login login = new Login();
        String username =LoginController.getLoginHome().getUsernameTxt().getText();       
        String password = LoginController.getLoginHome().getPasswordField().getText();
        Map<String , Object>  params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        try {
            login = GeneralDao.getGeneralDao().select("Login.findByUsernamePassword", params);
            if(login != null){
                IdController.getIdController().setId(login.getId());
                ViewController.getMenuBar().getPerson().setVisible(true);
                LoginController.getLoginHome().getStage().close();
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
