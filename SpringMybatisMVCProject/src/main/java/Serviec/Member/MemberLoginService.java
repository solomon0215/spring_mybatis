package Serviec.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Login.LoginCommand;
import Encrypt.Encrypt;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberLoginService {
	@Autowired
	MemberRepository memberRepository;
	
	public Integer loginPro(HttpSession session, LoginCommand loginCommand, HttpServletResponse response) {
		Integer result = 0;
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member = memberRepository.userCheck(member);
		if(member == null) {
			result = 0; //not found userID
		}else {
			if(member.getUserPw().equals(Encrypt.getEncryption(loginCommand.getPw()))) {
				AuthInfo authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(), member.getUserPw());
				session.setAttribute("authInfo", authInfo);
				setCookie(loginCommand, response);
				result = 1; // correct PW
			}else {
				result = -1;// Dismatch PW
			}
		}
		
		return result;
	}
	
	public void setCookie(LoginCommand loginCommand, HttpServletResponse response ){
		Cookie cookie = new Cookie("idStore", loginCommand.getId1());;
		if(loginCommand.getIdStore()) {
			cookie.setMaxAge(60*60*24*30);
		}else {
			cookie.setMaxAge(0);
		}
		Cookie autoLoginCookie = new Cookie("AutoLogin", loginCommand.getId1());
		if(loginCommand.getAutoLogin()) {
			autoLoginCookie.setMaxAge(60*60*24*30);
		}
		response.addCookie(autoLoginCookie);
		response.addCookie(cookie);
	}
}
