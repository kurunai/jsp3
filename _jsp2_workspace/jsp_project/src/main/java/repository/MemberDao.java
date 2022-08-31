package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDao {

	int insert(MemberVO mvo);

	List<MemberVO> selectList();

}
