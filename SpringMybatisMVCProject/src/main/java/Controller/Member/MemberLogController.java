package Controller.Member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Login.LoginCommand;
import Serviec.Member.MemberLoginService;
import Validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class MemberLogController {
	@Autowired
	MemberLoginService memberLoginService;
	@RequestMapping(method = RequestMethod.POST)
	public String loginPro(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse reponse) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "Main/main";
		}
		Integer i = memberLoginService.loginPro(session, loginCommand, reponse);
		if(i == 0){
			errors.rejectValue("id1", "notId");
			return "Main/main";
		}else if(i == -1) {
			errors.rejectValue("pw", "wrong");
			return "Main/main";
		}
		
		return "redirect:main";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String loginPro() {
		
		return "redirect:main";
	}
}
