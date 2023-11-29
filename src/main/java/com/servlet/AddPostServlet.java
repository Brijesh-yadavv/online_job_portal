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
import com.entity.Jobs;

@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");

			Jobs j = new Jobs();
			
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			j.setDescription(desc);
			
			HttpSession session = req.getSession();

			JobDAO dao = new JobDAO(DBconnect.getConn());
			boolean bol = dao.addJobs(j);
			if (bol) {
				// data is successfully inserted into database
				session.setAttribute("msg", "Job Post Successfully");
				resp.sendRedirect("add_job.jsp");
			} else {
				// data is not inserted into db
				session.setAttribute("msg", "Something wrong on server");
				resp.sendRedirect("add_job.jsp");

			}

		} catch (Exception e) {
			

		}
	}

}
