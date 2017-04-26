package com.tcs.bank.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.bank.database.GetDBConnection;

public class AuthenticationFilter implements Filter {
	private String UserId;
	private String UserPass;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		HttpSession session=req.getSession(false);
		if(session==null){
			System.out.println("Authentication fail.");
			resp.sendRedirect("login.jsp");
		}else
			
			this.UserId=session.getAttribute("").toString();
		this.UserPass=session.getAttribute("").toString();
		try {
			Connection connection=GetDBConnection.getDBConnection();
			Statement statement=connection.createStatement();
			String sql="select * from user_pass where user_id='"+UserId+"' and user_password='"+UserPass+"'";
			statement.executeQuery(sql);
			ResultSet set=statement.getResultSet();
			if(set.next()){
				System.out.println("Authentication successfull.");
				arg2.doFilter(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
