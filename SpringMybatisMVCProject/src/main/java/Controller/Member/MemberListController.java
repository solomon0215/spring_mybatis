package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.ListCommand;
import Serviec.Member.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	MemberListService	memberListService;
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String memberList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model, ListCommand listCommand) {
		
		return memberListService.memberList(model, page);
	}
}
