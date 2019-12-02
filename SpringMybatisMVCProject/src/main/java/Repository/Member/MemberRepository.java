package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Command.ListCommand;
import Model.DTO.MemberDTO;
import Model.DTO.PasswordChangeDTO;
import Model.DTO.StartEndPageDTO;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "MemberMapper";
	
	public Integer inserMember(MemberDTO dto) {
		String statement = namespace + ".memberInsert";
		Integer result = sqlSession.insert(statement, dto);
		return result;
	}
	public Integer getListCount(ListCommand listCommand) {
		String statement =  namespace + ".memberCount"; 
		return sqlSession.selectOne(statement,listCommand);
	}
	public List<MemberDTO> getMemberList(int page, int limit,
			ListCommand listCommand){
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO startEndPage =
				new StartEndPageDTO(startRow, endRow, listCommand);
		String statement =  namespace + ".memberList"; 
		return sqlSession.selectList(statement, startEndPage);
	}
	
	public Integer updatePassword(PasswordChangeDTO pwchange) {
		String statement = namespace + ".updatePassword";
		return sqlSession.update(statement, pwchange);
	}
	public MemberDTO memberCheck(MemberDTO member) {
		String statement =  namespace + ".userCheck";
		return sqlSession.selectOne(statement, member);
	}
	public Integer memberUpdate(MemberDTO member) {
		String statement =  namespace + ".memberUpdate";
		return sqlSession.update(statement, member);
	}
	public MemberDTO userCheck(MemberDTO member) {
		String statement =  namespace + ".userCheck";
		return sqlSession.selectOne(statement, member);
	}
	public Integer updateCheck(String num,String reciver,String name) {
		MemberDTO dto = new MemberDTO();
		dto.setUserEmail(reciver);
		dto.setUserName(name);
		dto.setUserCK(num);
		String statement = namespace + ".memberUserCk";
		return sqlSession.update(statement,dto);  // 0, 1
	}
	public List<String> selectMemberAll(){
		List<String> result = null;
		String statement =  namespace + ".selectMemberAll";
		result = sqlSession.selectList(statement);
		return result;
	}
}
