package service;

import java.util.List;

import domain.MemberVO;
import repository.MemberDAOImpl;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {
	private MemberDao mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		//dao에게 요청
		System.out.println("check 2-2");
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		System.out.println("check 3-2");
		return mdao.selectList();
	}
}
