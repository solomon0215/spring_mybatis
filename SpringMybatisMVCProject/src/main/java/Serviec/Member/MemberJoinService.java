package Serviec.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.MemberCommand;
import Encrypt.Encrypt;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberJoinService {
	@Autowired
	private MemberRepository memberRepository;
	
	public Integer join(MemberCommand memberCommand) {
		Integer result = null;
		MemberDTO dto = new MemberDTO();
		try {
		dto.setUserAddr(memberCommand.getUserAddr());
		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
		Date date = dt.parse(memberCommand.getUserBirth());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		Timestamp userBirth = new Timestamp(date.getTime());
		dto.setUserBirth(userBirth);
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserId(memberCommand.getUserId());
		dto.setUserName(memberCommand.getUserName());
		dto.setUserPh1(memberCommand.getUserPh1());
		dto.setUserPh2(memberCommand.getUserPh2());
		dto.setUserPw(
				Encrypt.getEncryption(memberCommand.getUserPw()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		result = memberRepository.insertMember(dto);
		return result;
	}
}
