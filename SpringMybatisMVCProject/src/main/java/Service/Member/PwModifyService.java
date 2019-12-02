package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import Command.ChangePwdCommand;
import Encrypt.Encrypt;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;
@Service
public class PwModifyService {
	@Autowired
	MemberRepository memberRepository;
	
	@Transactional
	public String pwModify(HttpSession session, 
			ChangePwdCommand changePwdCommand,Errors errors) {
		AuthInfo authinfo = (AuthInfo)session.getAttribute("authInfo");
		String id1 = authinfo.getId();
		MemberDTO member = new MemberDTO();
		member.setUserId(id1);
		member.setUserPw(
				Encrypt.getEncryption(
						changePwdCommand.getCurrentPassword()));
		member = memberRepository.memberCheck(member);
		if(member != null) {
			return "member/memberPwModify";
		}else {
			errors.rejectValue("currentPassword", "notCurrent");
			return "member/memberPw";
		}
	}
}
