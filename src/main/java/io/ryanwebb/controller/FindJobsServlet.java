package io.ryanwebb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindJobsServlet extends HttpServlet
{
	
	private static final long serialVersionUID = -5582311684512088608L; // Keep compiler happy

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		resp.sendRedirect("/index.jsp");
		PrintWriter out = resp.getWriter();
		String params = req.getParameter("f_elem_city");
		out.write(params);
	}
}
