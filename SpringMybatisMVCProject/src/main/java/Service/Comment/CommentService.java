package Service.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Model.DTO.CommentDTO;
import Model.DTO.CommentReplyDTO;
import Model.DTO.ReplyDTO;
import Model.DTO.UserCommentDTO;
import Repository.Comment.CommentRepository;

@Repository
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	public void commentSelect(Model model) {
		String commentNo = null;
		List<CommentDTO> commentlist = 
				commentRepository.commentAllSelect(commentNo);
		System.out.println("commentSelect : " + commentlist.size());
		model.addAttribute("comments",commentlist );
	}
	public void commentDynamicsqlForeach(String [] commentNos,
			Model model) {
		List<Long> cs  = new ArrayList<Long>(); // 배열 -> 리스트 -> 맵  IN을 맵퍼에서 쓰기 위한 단계 바티스는 맵만 받는다.
		for(String str : commentNos) { // 11,2,55
			cs.add(Long.valueOf(str));
		}
		Map<String, Object> condition = new HashMap<String, Object>(); 
		condition.put("commentNos", cs);
		
		List<CommentDTO> commentlist = 
				commentRepository.commentDynamicsqlForeach(condition);
		model.addAttribute("comments",commentlist );
	}
	public void commentInfo(Model model, String commentNo) {
		System.out.println("commentInfo : " + commentNo);
		CommentReplyDTO commentReply = 
				commentRepository.commentCollection(commentNo);
		CommentDTO comment = null;
		if(commentReply == null) {
			List<CommentDTO> commentlist = 
					commentRepository.commentAllSelect(commentNo);
			comment = commentlist.get(0);
		}
		model.addAttribute("comment",comment );
		model.addAttribute("commentReply",commentReply );
	}
	public void replyInsert(ReplyDTO reply, HttpSession session,
			HttpServletRequest request) {
		reply.setIpAddr(request.getRemoteAddr());
		reply.setUserId(
				((AuthInfo)session.getAttribute("authInfo")).getId());
		System.out.println("replyInsert : " + reply.getUserId());
		commentRepository.replyInsert(reply);
	}
}
