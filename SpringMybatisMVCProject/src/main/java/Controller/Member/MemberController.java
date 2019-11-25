package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Serviec.Member.MemberJoinService;
import Validator.MemberCommandValidator;

@Controller
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@RequestMapping("/register/agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping("/register/regist")
	public String regist(@RequestParam(value="agree", defaultValue = "false") Boolean agree, MemberCommand memberCommand ) {
		if(!agree) {
			return "member/agree";
		}
		return "member/memberForm";
	}
	@RequestMapping("/register/memberJoinAction")
	public String memberJoin(MemberCommand memberCommand , Errors errors) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
		Integer result = memberJoinService.join(memberCommand);
		if(result == null) {
			errors.rejectValue("userId", "duplicate");
			return "member/memberForm";
		}
		return "member/memberWelcome";
	}
}
