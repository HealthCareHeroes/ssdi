package edu.uncc.ssdi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public User validateUser(Login login) {
		
		
		String sql = "select * from User where email= '"+ login.getUserName()+ "' and password = '" + login.getPassword() + "'";
		
		List<User> users = jdbcTemplate.query(sql , new UserMapper());
		
		return users.size() > 0 ? users.get(0) : null;
	
	}
	
	@Override
	public User validateEmail(String email) {
		
		User user = new User();
	/*	String sql = "select * from User where email= '"+ email;
		
		List<User> users = jdbcTemplate.query(sql , new UserMapper());
		
		
		return users.size() > 0 ? users.get(0) : null;*/
		 String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/db_example";
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      try {
	      Class.forName(myDriver);
	       conn = DriverManager.getConnection(myUrl, "root", "root");
	      
	
		//	 String query = ("select * from User where email = '"+email+ "'");

		 //String query = "select * from User where first_name =  ? "; // working for first Name 
		 	 String query = "select * from User where email =  ? "; 

		 /*   String query = "select COF_NAME, SUP_ID, PRICE, " +
		                   "SALES, TOTAL " +
		                   "from " + dbName + ".COFFEES";*/
		   
		// Statement    stmt =  (Statement) conn.createStatement();
		 	 
		 	 System.out.println(email);
		 stmt = conn.prepareStatement(query);
		 stmt.setString(1, email);
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		        	
		        	System.out.println("Here");
		        	user.setId(Integer.valueOf(rs.getString("id")));
					user.setEmail((rs.getString("email")));
					user.setFirstName((rs.getString("first_name")));
					
		        }
		        
		        stmt.close();
		    } catch (SQLException | ClassNotFoundException e ) {
		       e.printStackTrace();
		    } finally {
		    
		    }
		    return user;
		    
	}
	
	class UserMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int arg1) throws SQLException {

			User user = new User();
			user.setId(Integer.valueOf(rs.getString("id")));
			user.setEmail((rs.getString("email")));
			user.setFirstName((rs.getString("first_name")));
			return user;
		}
		
	}


	

}
