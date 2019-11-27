package Serviec.Member;

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
	
	public Integer loginPro(HttpSession session, LoginCommand loginCommand) {
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
				result = 1; // correct PW
			}else {
				result = -1;// Dismatch PW
			}
		}
		
		return result;
	}
}
