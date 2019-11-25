package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;

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
}
