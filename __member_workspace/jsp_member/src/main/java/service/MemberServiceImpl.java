package service;

import java.util.List;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao; //interface => repository에 생성
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl(); //구현클래스 생성 => repository에 생성
	}

	@Override
	public int register(MemberVO mvo) {
		// dao에게 요청
		System.out.println("check 2-2");
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		System.out.println("check 3-2");
		return mdao.selectList();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		
		return mdao.selectOne(mvo);
	}

	@Override
	public MemberVO getDetail(String id) {
		return mdao.detail(id);
	}

	@Override
	public int modify(MemberVO mvo) {
		
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		
		return mdao.delete(id);
	}


}