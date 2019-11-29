package Model.DTO;

import java.sql.Timestamp;

public class CommentDTO {
	private Long commentNo;
	private String userId;
	private String commentSubject;
	private String commentContent;
	private Timestamp regDate;
	
	public CommentDTO() {
	}
	
	public CommentDTO(Long commentNo, String userId, String commentSubject, String commentContent, Timestamp regDate) {
		super();
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentSubject = commentSubject;
		this.commentContent = commentContent;
		this.regDate = regDate;
	}
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentSubject() {
		return commentSubject;
	}
	public void setCommentSubject(String commentSubject) {
		this.commentSubject = commentSubject;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
