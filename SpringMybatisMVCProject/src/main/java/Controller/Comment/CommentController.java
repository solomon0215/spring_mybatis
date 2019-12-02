package Controller.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.CommentCommand;
import Model.DTO.ReplyDTO;
import Service.Comment.CommentInsertService;
import Service.Comment.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentInsertService commentInsertService;
	@Autowired
	CommentService commentService;
	@RequestMapping(value="/comment/commentList", 
			method = RequestMethod.GET)
	public String commantList(CommentCommand commantCommand,
			Model model) {
		commentService.commentSelect(model);
		return "comment/commentList";
	}
	@RequestMapping(value="/comment/commentList", 
			method = RequestMethod.POST)
	public String commentDynamicsqlForeach(
			@RequestParam(value="commentNos") String []commentNos,
			Model model) {
		commentService.commentDynamicsqlForeach(commentNos,model);
		return "comment/commentList";
	}
	@RequestMapping("/comment/commentReg")
	public String form(CommentCommand commantCommand) {
		return  "comment/commentForm";
	}
	@RequestMapping("/comment/commentInsert")
	public String insert(CommentCommand commentCommand,
			HttpSession session, HttpServletRequest request) {
		Integer i = commentInsertService.commentReg(
				commentCommand, session, request);
		return "redirect:/comment/commentList";
	}
	@RequestMapping("/comment/commantCollection/{id}")
	public String commentInfo(@PathVariable("id") String commentNo, 
			Model model) {
		commentService.commentInfo(model, commentNo);
		return "comment/commentCollection";
	}
	@RequestMapping("/comment/replyPro")
	public String replyInsert(ReplyDTO reply, HttpSession session,
			 HttpServletRequest request) {
		commentService.replyInsert(reply, session, request);
		return "redirect:/comment/commantCollection/"+reply.getCommentNo();
	}
}
