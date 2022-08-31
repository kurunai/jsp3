package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo);

	int updateLogin(String email);

	List<MemberVO> selectList();

	MemberVO selectOne(String email);

	int update(MemberVO mvo);

	int delete(String email);

}
