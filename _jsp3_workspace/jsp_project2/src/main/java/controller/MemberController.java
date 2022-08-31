package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp; // 응답에 대한 요청과 응답을 주고 받는 값.
	private MemberService msv;
	private String destPage; //목적지 페이지
	private int isUp; //완료된 요청에 대한 값.
       

    public MemberController() {
        msv = new MemberServiceImpl(); //구현 클래스
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI(); // /mem/list 식으로 표현
		String path = uri.substring(uri.lastIndexOf("/")+1);	// /list   +1(다음값) 해주면 / 제외하고
		log.info(">>> URI : " + uri);
		log.info(">>> path : " + path); //check 값이 잘 나오는지 체크
		
		switch(path) {
		case "login":	// login page open
			destPage = "/member/login.jsp";
			break;
			
		case "login_auth":	//login작업이 일어나는 위치
			MemberVO mvo = msv.login(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd")));
			if(mvo != null) {
				//세션을 가져오기
				//연결된 세션이 없다면 새로 생성
				HttpSession ses = req.getSession();	
				//ses로 mvo를 바인딩 한다.
				ses.setAttribute("ses", mvo);
				ses.setMaxInactiveInterval(600);	// 초단위 60*10 = 10분
			}else {
				req.setAttribute("msg_login", 0);	//false란 의미의 0
			}
			destPage = "/"; 	//index페이지
			break;
			
		case "logout":
			//연결된 세션이 있다면 해당 세션 가져오기
			HttpSession ses = req.getSession();
			ses.invalidate();	//접속 끊기
			//로그인 정보 email 값을 가져와서 로그인 시간 update
			isUp = msv.lastLogin(req.getParameter("email"));
			log.info(">>> logout : " + (isUp > 0 ? "ok" : "fai;"));
			destPage = "/";
			break;
			
		case "join":	//회원가입 page open
			destPage = "/member/join.jsp";
			break;
			
		case "register":	//회원가입이 일어나는 위치
			isUp = msv.register(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nick_name")));
			log.info(">>> join > " + (isUp > 0 ? "ok" : "fail"));
			destPage = "login";	//index로 가고 싶다면 "/"
			break;
		
		case "list":	//전체 리스트 검색
			req.setAttribute("list", msv.getList());
			destPage = "/member/list.jsp";
			break;
		
		case "modify":	//번호를 주고 해당 번호의 값 1개를 검색해서 open 파일에 전달
			req.setAttribute("mvo", msv.getDetail(req.getParameter("email")));
			destPage = "/member/modify.jsp";
			break;
			
		case "update":	//실제 수정이 일어나는 위치
			isUp = msv.modify(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nick_name")));
			log.info(">>> Update > " + (isUp > 0 ? "ok" : "fail"));
			destPage = "list";
			break;
		
		case "remove":	//실제 삭제가 일어나는 위치
			isUp = msv.remove(req.getParameter("email"));
			log.info(">>> remove > " + (isUp > 0 ? "ok" : "fail"));
			destPage = "list";
			break;
			
		}
		
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
