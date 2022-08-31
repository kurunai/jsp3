package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseBuilder {
	private static SqlSessionFactory factory;
	private static final String configLoc = "orm/MybatisConfig.xml";
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(configLoc));
		} catch (Exception e) {
			// 마이바티스 설정 오류시 메시지
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		
		return factory;
	}

}
