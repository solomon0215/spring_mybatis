package Repository.Comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;
import Model.DTO.CommentReplyDTO;
import Model.DTO.ReplyDTO;
import Model.DTO.UserCommentDTO;
@Repository
public class CommentRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "Repository.Comment.CommentMapper";
	
	public Integer commentInsert(CommentDTO commentDTO) {
		Integer result = null;
		String statement = namespace + ".insertComment";
		result = sqlSession.insert(statement, commentDTO);
		return result;
	}
	public List<CommentDTO> commentAllSelect(String commentNo1){
		String statement = namespace + ".commentAllSelect";
		System.out.println("commentAllSelect : " + commentNo1);
		List<CommentDTO> list =
				 sqlSession.selectList(statement, commentNo1);
		System.out.println("commentAllSelect : " + list.size());
		return list;
	}
	public CommentReplyDTO commentCollection(String commentNo) {
		String statement = namespace + ".commentCollection";
		CommentReplyDTO commentReply = 
				sqlSession.selectOne(statement, commentNo);
		return commentReply;
	}
	public void replyInsert(ReplyDTO reply) {
		String statement = namespace + ".replyInsert";
		sqlSession.insert(statement, reply);
	}
	public List<CommentDTO> commentDynamicsqlForeach(Map<String, Object> condition) {
		String statement = namespace + ".selectCommentForeach";
		return sqlSession.selectList(statement, condition);
	}
}