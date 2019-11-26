package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Serviec.Member.MemberOkService;

@Controller
@RequestMapping("memberMail")
public class MemberMailController {
	@Autowired
	private MemberOkService memberOkService;
	@RequestMapping(method = RequestMethod.GET)
	public String memberMail(@RequestParam("num") String num, @RequestParam("reciver") String reciver,
			@RequestParam("name") String name) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println("asdasdasd-----------------");
		String path = memberOkService.updateCheck(num, reciver, name);
		return path;
	}
}
