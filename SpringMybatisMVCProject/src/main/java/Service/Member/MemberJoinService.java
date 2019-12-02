package Service.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Command.MemberCommand;
import Encrypt.Encrypt;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberJoinService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	MemberRegMailService memberRegMailService;
	
	@Transactional
	public Integer join(MemberCommand memberCommand) {
		MemberDTO dto = PubMember.execute(memberCommand);
		Integer result = memberRepository.inserMember(dto);
		memberRegMailService.sendMail(dto.getUserEmail(), 
				dto.getUserName());
		return result;
	}
}








