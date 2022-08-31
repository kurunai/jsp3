package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static DatabaseConnector dbc = new DatabaseConnector();
	private Connection conn = null;	//데이터베이스 접속 관련 규격
	//Connector/java 에서 제공하는 클래스
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	//mysql 프로그램 접근 위치
	private String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
	
	private DatabaseConnector() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "tester", "mysql");	//경로설정
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");  	//라이브러리 셋팅 오류
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
			
	}
	
	public static DatabaseConnector getInstance() {	//싱글톤 방식
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}
