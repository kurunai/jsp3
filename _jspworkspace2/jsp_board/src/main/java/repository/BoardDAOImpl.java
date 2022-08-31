package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	// DB와 연결
	private SqlSession sql;
	private final String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder(); // orm -> db연결 클래스
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		System.out.println("check 3");
		int isUp = sql.insert(NS+"add", bvo); // insert가 완료되면 1을 리턴
		//System.out.println("check3-2 " + isUp);
		if(isUp > 0) {
			sql.commit(); // 완료가 되었다면 commit
		}
		return isUp;
	}

	@Override
	public List<BoardVO> selectList() {
		
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectDetail(int bno) {
		System.out.println("check 3-3");
		return sql.selectOne(NS+"detail",bno);
	}

	@Override
	public int update(BoardVO bvo) {
		System.out.println("check 4-3");
		int isUp = sql.update(NS+"mod", bvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(int bno) {
		System.out.println("check 5-3");
		int isUp = sql.delete(NS+"del", bno);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	

}
