package Controller.Member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Serviec.Member.MemberLogoutService;

@Controller
public class MemberLogoutController {
	@Autowired
	MemberLogoutService memberLogoutService;
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		memberLogoutService.logout(session,response);
		return "redirect:main";
	}
}
