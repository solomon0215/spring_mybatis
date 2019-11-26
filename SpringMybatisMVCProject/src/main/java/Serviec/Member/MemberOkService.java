package Serviec.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.Member.MemberRepository;

@Service
public class MemberOkService {
	@Autowired
	private MemberRepository memberRepository;
	
	public String updateCheck(String num , String reciver, String name) {
		Integer result = memberRepository.updateCheck(num, reciver, name);
		if(result != 0) {
			return "member/memberMailTrue";
		}
		return "member/memberMailFalse";
	}
}
