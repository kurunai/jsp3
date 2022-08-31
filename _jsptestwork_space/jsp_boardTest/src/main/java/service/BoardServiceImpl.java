package service;

import java.util.List;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}
	@Override
	public int register(BoardVO bvo) {
		System.out.println("check 2");
		return bdao.insert(bvo);
	}
	@Override
	public List<BoardVO> getList() {
		System.out.println("check 2-2");
		return bdao.selectList();
	}
	
}
