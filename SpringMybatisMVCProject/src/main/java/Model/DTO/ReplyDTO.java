package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
@SuppressWarnings("serial")
public class ReplyDTO implements Serializable{
	Long replyNo; 
	Long commentNo;
	String userId;
	String commentContent;
	Timestamp regDate;
	String ipAddr;
	public ReplyDTO() {}
	public ReplyDTO(Long replyNo, Long commentNo, String userId, 
			String commentContent, Timestamp regDate,
			String ipAddr) {
		super();
		this.replyNo = replyNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.regDate = regDate;
		this.ipAddr = ipAddr;
	}
	public Long getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Long replyNo) {
		this.replyNo = replyNo;
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
