package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.ListCommand;
import Service.Member.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("/member/list")
	public String member_list(@RequestParam(value = "page" ,
	defaultValue = "1")	Integer page, Model model,
			ListCommand listCommand, Errors errors) {
		if (errors.hasErrors()) {
			return "member/memberList";
		}
		return memberListService.memberList(model, page,listCommand);
	}
}




