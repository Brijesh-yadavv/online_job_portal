package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.JobDAO;
import com.db.DBconnect;

@WebServlet("/delete")
public class DeleteJob extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			HttpSession session=req.getSession();
			JobDAO dao=new JobDAO(DBconnect.getConn());
			boolean bol=dao.deleteJobs(id);
			if (bol) {
				// data is successfully inserted into database
				session.setAttribute("msg", "Job Deleted Successfully");
				resp.sendRedirect("view_jobs.jsp");
			} else {
				// data is not inserted into db
				session.setAttribute("msg", "Something wrong on server");
				resp.sendRedirect("view_jobs.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
