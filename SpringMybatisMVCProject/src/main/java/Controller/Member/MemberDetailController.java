package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.MemberCommand;
import Service.Member.MemberDetailService;
import Service.Member.MemberModifyService;
import Validator.MemberCommandValidator;

@Controller
public class MemberDetailController {
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired 
	MemberModifyService memberModifyService;
	@RequestMapping("/member/memberDetail")
	public String detail(HttpSession session, Model model) {
		memberDetailService.detail(session, model);
		return "member/memberDetail";
	}
	@RequestMapping("/member/memberModify")
	public String detail(HttpSession session, 
			MemberCommand memberCommand) {
		memberDetailService.modify(session, memberCommand);
		return "member/memberModify";
	}
	@RequestMapping("/member/memberModifyPro")
	public String ModifyPro(MemberCommand memberCommand,Errors errors) {
		memberCommand.setUserPwCon(memberCommand.getUserPw());
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			System.out.println("a");
			return "member/memberModify";
		}
		Integer result = memberModifyService.modifyPro(memberCommand);
		if(result == 0) {
			errors.rejectValue("userPw", "badPw");
			return "member/memberModify";
		}
		return "redirect:/member/memberDetail";
	}
}










