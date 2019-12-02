package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserCommentDTO  implements Serializable {
	private MemberDTO memberDTO;
	private CommentDTO commentDTO;
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public CommentDTO getCommentDTO() {
		return commentDTO;
	}
	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}
}
