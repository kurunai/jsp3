package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDao {
	//DB와 연결되서 데이터를 처리
	private SqlSession sql;
	private final String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		System.out.println("check 2-3");
		int isUp = sql.insert(NS+"reg", mvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<MemberVO> selectList() {
		System.out.println("check 3-3");
		return sql.selectList(NS+"list");
	}
}
