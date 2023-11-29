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



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			User u=new User();
			HttpSession session=req.getSession();

			if ("admin@gmail.com".equals(email) && "admin@121".equals(pass)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			} else {
				UserDAO dao=new UserDAO(DBconnect.getConn());
				User user=dao.login(email,pass);
				if(user!=null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("user_jobs.jsp");
				}
				else {
					session.setAttribute("succMsge", "Invalid login credential");
					
					resp.sendRedirect("login.jsp");
					
				}
			}

		} catch (Exception e) {
			

		}
	}
}
