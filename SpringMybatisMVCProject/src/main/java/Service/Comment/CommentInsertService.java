package Service.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Command.CommentCommand;
import Model.DTO.AuthInfo;
import Model.DTO.CommentDTO;
import Repository.Comment.CommentRepository;

@Service
public class CommentInsertService {
	@Autowired
	CommentRepository commentRepository;
	
	@Transactional
	public Integer commentReg(CommentCommand commantCommand,
			HttpSession session, HttpServletRequest request) {
		CommentDTO comment = new CommentDTO();
		comment.setCommentSubject(commantCommand.getCommentSubject());
		comment.setCommentContent(commantCommand.getCommentContent());
		comment.setUserId(
				((AuthInfo)session.getAttribute("authInfo")).getId());
		comment.setIpAddr(request.getRemoteAddr());
		return commentRepository.commentInsert(comment);
	}
}
