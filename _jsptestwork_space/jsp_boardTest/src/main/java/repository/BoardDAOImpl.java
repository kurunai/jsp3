package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	//DB와 연결
	private SqlSession sql;
	private final String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();	//orm -> db연결 클래스
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(BoardVO bvo) {
		System.out.println("check 3");
		int isUp = sql.insert(NS+"add", bvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public List<BoardVO> selectList() {
		return sql.selectList(NS+"list");
	}

}
