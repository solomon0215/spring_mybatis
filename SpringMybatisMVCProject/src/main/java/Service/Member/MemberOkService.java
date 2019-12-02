package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Repository.Member.MemberRepository;

@Service
public class MemberOkService {
	@Autowired
	MemberRepository memberRepository ;
	
	@Transactional
	public String updateCheck(String num,String reciver,String name) {
		Integer result = memberRepository.updateCheck(num,reciver,name);
		if(result == 0) {
			return "member/memberMailFalse";
		}else {
			return "member/memberMailTrue";
		}
	}
}
