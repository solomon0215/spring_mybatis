package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.ChangePwdCommand;
import Service.Member.ChangePasswordModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
@RequestMapping("/edit/pwModifyPro")
public class ChangePasswordModifyController {
	@Autowired
	ChangePasswordModifyService changePasswordModifyService; 
	@RequestMapping(method = RequestMethod.POST)
	public String Modify(ChangePwdCommand changePwdCommand, 
			Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPwModify";
		}
		String path = 
				changePasswordModifyService.pwChange(changePwdCommand,
				errors, session);
		return path; // 
	}
}
