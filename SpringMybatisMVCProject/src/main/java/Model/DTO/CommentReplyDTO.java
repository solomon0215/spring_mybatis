package Model.DTO;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CommentReplyDTO implements Serializable{
	private CommentDTO commentDTO;
	private List<ReplyDTO> replys;
	public CommentDTO getCommentDTO() {
		return commentDTO;
	}
	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}
	public List<ReplyDTO> getReplys() {
		return replys;
	}
	public void setReplys(List<ReplyDTO> replys) {
		this.replys = replys;
	}
}
