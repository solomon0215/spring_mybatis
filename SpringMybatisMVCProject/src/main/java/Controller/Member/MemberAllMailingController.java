package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Serviec.Member.EmailAllService;

@Controller
@RequestMapping("/memberAllMail")
public class MemberAllMailingController {
	@Autowired
	EmailAllService emailAllService;
	@RequestMapping(method = RequestMethod.GET)
	public String mailling() {
		emailAllService.sendAll();
		return "mail/mailSecces";
	}
}
