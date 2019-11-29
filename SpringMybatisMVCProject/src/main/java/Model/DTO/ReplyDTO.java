package Model.DTO;

import java.sql.Timestamp;

public class ReplyDTO {
	private Integer replyNo;
	private String userId;
	private Integer commentNo;
	private String commentContent;
	private Timestamp regDate;
	private String ipAddr;

	public ReplyDTO() {	}

	public ReplyDTO(Integer replyNo, String userId, Integer commentNo, String commentContent, Timestamp regDate,
			String ipAddr) {
		super();
		this.replyNo = replyNo;
		this.userId = userId;
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.regDate = regDate;
		this.ipAddr = ipAddr;
	}
	

}
