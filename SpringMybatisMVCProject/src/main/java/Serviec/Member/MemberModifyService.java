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
public class MemberModifyService {
	@Autowired
	MemberRepository memberRepository;
	
	public Integer modifyPro(MemberCommand memberCommand) {
		
		MemberDTO dto = MemberPub.execute(memberCommand);
		Integer result = memberRepository.memberUpdate(dto);
		return result;
	}
}
