package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDAO;
import com.db.DBconnect;
import com.entity.User;

@WebServlet("/add_user")
public class Register_servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("name");
			String qua=req.getParameter("qua");
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			
			UserDAO dao=new UserDAO(DBconnect.getConn());
			User u=new User(name,email,pass,qua,"user");
			boolean f=dao.userAdd(u);
			
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Registration Successfully");
				resp.sendRedirect("signup.jsp");
			}
			else {
				session.setAttribute("succMsg", "Something went wrong on server");
				resp.sendRedirect("signup.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
