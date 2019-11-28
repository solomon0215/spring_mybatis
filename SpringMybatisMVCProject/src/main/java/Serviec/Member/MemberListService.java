package Serviec.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public String memberList(Model model, Integer page) {
		int limit = 10;
		List<MemberDTO> list = memberRepository.getMemberList(page, limit);
		int listCount = memberRepository.getListCount();
		int maxPage = (int) ((double)listCount/limit +0.95);
		int startPage  = (int) (((double)page / 10 +0.9)-1) *10 +1;
		int endPage = startPage +10 -1;
		if(endPage > maxPage) endPage= maxPage;
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("listCount", listCount);
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
}
