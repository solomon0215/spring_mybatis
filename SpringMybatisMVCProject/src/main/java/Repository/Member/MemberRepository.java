package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Command.Member.ListCommand;
import Model.DTO.MemberDTO;
import Model.DTO.PasswordChangeDTO;
import Model.DTO.StartEndPage;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="MemberMapper";
	
	public Integer insertMember(MemberDTO dto) {
		String statement = namespace + ".memberInsert";
		Integer result = sqlSession.insert(statement,dto);
		return result;
	}
	
	public Integer updateCheck(String num, String reciver, String name) {
		MemberDTO dto = new MemberDTO();
		dto.setUserEmail(name);
		dto.setUserName(name);
		dto.setUserCk(num);
		String statement = namespace + ".memberUserCk";
		
		return sqlSession.update(statement, dto);
	}
	public List<String> selectMemberAll(){
		String statement = namespace + ".memberUserEmail";
		List<String> list = null;
		list =sqlSession.selectList(statement);
		return list;
	}
	
	public MemberDTO userCheck(MemberDTO member) {
		String statement = namespace + ".userCheck";
		return sqlSession.selectOne(statement, member);
	}
	
	public Integer memberUpdate(MemberDTO dto) {
		String statement = namespace + ".memberUpdate";
		return sqlSession.update(statement, dto);
	}
	public MemberDTO memberCheck(MemberDTO member) {
		String statement = namespace + ".userCheck";
		return sqlSession.selectOne(statement, member);
	}
	
	public Integer updatePassword(PasswordChangeDTO pwchange) {
		String statement = namespace + ".updatePassword";
		return sqlSession.update(statement, pwchange);
	}
	public List<MemberDTO> getMemberList(Integer page,Integer limit,ListCommand listCommand){
		Long startRow = ((long)page-1)*10+1; 
		Long endRow = startRow + limit -1;
		StartEndPage startEndPage = new StartEndPage(startRow, endRow,listCommand);
		String statement = namespace + ".memberList";
		return sqlSession.selectList(statement, startEndPage);
	}
	public Integer getListCount(ListCommand listCommand) {
		String statement  = namespace + ".memberCount";
		return sqlSession.selectOne(statement,listCommand);
	}
}
