package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	int register(BoardVO boardVO);

	List<BoardVO> getList();

}
