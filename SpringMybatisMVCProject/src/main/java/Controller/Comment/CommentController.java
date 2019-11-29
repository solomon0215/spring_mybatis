package Controller.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Comment.CommentCommand;

@Controller
public class CommentController {
	@Autowired
	CommentInsertService commentInsertService;
	
	@RequestMapping("/comment/commentList")
	public String commentList() {
		return "comment/commentList";
	}
	@RequestMapping("/comment/commentReg")
	public String form(CommentCommand commentCommand) {
		return "comment/commentForm";
	}
	@RequestMapping("/comment/commentInsert")
	public String insert(CommentCommand commentCommand, HttpSession session) {
		Integer i = commentInsertService.commentReg(commentCommand,session);
		return "redirect:comment/commentList";
	}
}
