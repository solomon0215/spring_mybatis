package Serviec.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;
@Service
public class MemberDetailService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void detail(HttpSession session, Model model) {
		MemberDTO member = new MemberDTO();
		member.setUserId( 
				((AuthInfo)session.getAttribute("authInfo")).getId()
				);
		member = memberRepository.userCheck(member);
		model.addAttribute("member", member);
	}
	
	public void modify(HttpSession session, MemberCommand memberCommand) {
		MemberDTO member = new MemberDTO();
		member.setUserId( 
				((AuthInfo)session.getAttribute("authInfo")).getId()
				);
		member = memberRepository.userCheck(member);
		memberCommand.setUserId(member.getUserId());
		memberCommand.setUserName(member.getUserName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // setting date format
		String birth = sdf.format(new Date(member.getUserBirth().getTime())); // timestamp -> time(millisecond)->date -> String 
		
		memberCommand.setUserBirth(birth);
		memberCommand.setUserPh1(member.getUserPh1());
		memberCommand.setUserPh2(member.getUserPh2());
		memberCommand.setUserGender(member.getUserGender());
		memberCommand.setUserAddr(member.getUserAddr());
		memberCommand.setUserEmail(member.getUserEmail());
	}
}
