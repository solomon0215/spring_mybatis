package Service.Main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Command.LoginCommand;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;
@Service
public class MainService {
	@Autowired
	MemberRepository memberRepository;
	
	public void autoLogin(LoginCommand loginCommand,
			HttpSession session) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member = memberRepository.userCheck(member);
		AuthInfo authInfo = new AuthInfo(member.getUserId(),
				member.getUserEmail(), member.getUserName(),
				member.getUserPw());
		session.setAttribute("authInfo",authInfo);
	}
}
