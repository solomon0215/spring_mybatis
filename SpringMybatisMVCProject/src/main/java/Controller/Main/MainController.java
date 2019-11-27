package Controller.Main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Login.LoginCommand;
import Service.Main.MainService;

@Controller
@RequestMapping("main")
public class MainController {
	@Autowired
	MainService mainService;
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand, 
			@CookieValue(value="idStore", required = false) Cookie idStore,
			@CookieValue(value="AutoLogin", required = false) Cookie AutoLogin,
			HttpSession session) {
		if(idStore != null) {
			loginCommand.setIdStore(true);
			loginCommand.setId1(idStore.getValue());
		}
		if(AutoLogin != null) {
			loginCommand.setId1(AutoLogin.getValue());
			mainService.autoLogin(loginCommand,session);
		}
		
		return "Main/main";
	}
}
