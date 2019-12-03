package Repository.Domino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.ADTO;
import Model.DTO.BDTO;
import Model.DTO.CDTO;

@Repository
public class DominoRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "DominoMapper";
	
	public List<ADTO> selectA(){
		String statement = namespace + ".selectA";
		return sqlSession.selectList(statement);
	}
	
	public List<BDTO> selectB(Long a){
		String statement = namespace + ".selectB";
		return sqlSession.selectList(statement, a);
	}
	public List<CDTO> selectC(BDTO bdto){
		String statement = namespace + ".selectC";
		return sqlSession.selectList(statement, bdto);
	}
}
