package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import Command.ChangePwdCommand;
import Encrypt.Encrypt;
import Model.DTO.AuthInfo;
import Model.DTO.PasswordChangeDTO;
import Repository.Member.MemberRepository;

@Service
public class ChangePasswordModifyService {
	@Autowired
	MemberRepository memberRepository ;
	
	@Transactional
	public String pwChange(ChangePwdCommand changePwdCommand,
			Errors errors,HttpSession session) {
		PasswordChangeDTO pwchange = new PasswordChangeDTO();
		pwchange.setUserId(
				((AuthInfo)session.getAttribute("authInfo")).getId());
		pwchange.setPw1(
				Encrypt.getEncryption(
						changePwdCommand.getCurrentPassword()));
		pwchange.setNewPw(
				Encrypt.getEncryption(
						changePwdCommand.getNewPassword()));
		Integer result = memberRepository.updatePassword(pwchange);
		if(result == 0) {
			errors.rejectValue("currentPassword", "notCurrent");
			return "member/memberPwModify";
		}
		return "redirect:/member/memberDetail";
	}
}
