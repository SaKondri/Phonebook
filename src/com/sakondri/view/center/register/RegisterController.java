package com.sakondri.view.center.register;

public class RegisterController {
	private static RegisterEvent registerEvent;
	private static RegisterHome registerHome;
	
	private RegisterController() {
		
	}
	public synchronized static RegisterEvent getRegisterEvent() {
		if(registerEvent == null){
			registerEvent = new RegisterEvent();
		}
		return registerEvent;
	}
	public synchronized static RegisterHome getRegisterHome() {
		if(registerHome == null){
			registerHome = new RegisterHome();
		}
		return registerHome;
	}
	public static void setRegisterHome(RegisterHome registerHome) {
		RegisterController.registerHome = registerHome;
	}
}
