package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class CommentDTO  implements Serializable {
	private Long commentNo;
	private String userId;
	private String commentSubject;
	private String commentContent;
	private Timestamp regDate;
	private String ipAddr;
	public CommentDTO() {}
	public CommentDTO(Long commentNo, String userId, String commentSubject,
			String commentContent, Timestamp regDate,String ipAddr) {
		super();
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentSubject = commentSubject;
		this.commentContent = commentContent;
		this.regDate = regDate;
		this.ipAddr = ipAddr;
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
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
}
