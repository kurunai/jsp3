package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao;	//interface 생성 -> repository생성
	//log를 찍어볼때만 적용
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	

	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();	//class 생성 -> repository생성
	}
	
	@Override
	public int register(BoardVO bvo) {
		// service -> dao db처리를 부탁
		log.info("inser >>  + service");
		return bdao.insert(bvo);
	}	//인터페이스 추가 repository에 추가

	@Override
	public List<BoardVO> getList() {
		log.info("list >> service");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail >> service");
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("update >> service");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info("delete >> service");
		return bdao.delete(bno);
	}
	
}
