package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.ChangePwdCommand;
import Service.Member.PwModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePasswordController {
	@Autowired
	private PwModifyService pwModifyService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(ChangePwdCommand changePwdCommand) {
		return "member/memberPw";// CurrentPassword만 있음.
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(ChangePwdCommand changePwdCommand, 
			Errors errors, HttpSession session) {
		// CurrentPassword가 비었는지 확인 
		changePwdCommand.setNewPassword(changePwdCommand.getCurrentPassword());
		changePwdCommand.setReNewPassword(changePwdCommand.getCurrentPassword());
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPw";
		}
		String path = pwModifyService.pwModify(session, changePwdCommand,
				errors);
		return path;
	}	
	
}
