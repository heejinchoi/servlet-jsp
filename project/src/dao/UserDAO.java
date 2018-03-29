package dao;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UserDAO {
	
	DataSource dataFactory;
	
	public UserDAO() {
		
		try {
			Context context = new InitialContext();
			//dataFactory = context.lookup("");
			
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	

}
