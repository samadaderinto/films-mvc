package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.FilmDB;
import models.Film;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Default pagination parameters
//		int limit = 10; // Default number of items per page
//		int offset = 0; // Default starting position
//
//		// Try to parse limit and offset from request parameters, if present
//		try {
//			String limitParam = request.getParameter("limit");
//			if (limitParam != null) {
//				limit = Integer.parseInt(limitParam);
//			}
//
//			String offsetParam = request.getParameter("offset");
//			if (offsetParam != null) {
//				offset = Integer.parseInt(offsetParam);
//			}
//		} catch (NumberFormatException e) {
//			// If parsing fails, default values are used
//			System.out.println("Invalid pagination parameters. Using defaults.");
//		}
//
//		String searchStr = request.getParameter("searchStr");
//		FilmDAO dao = new FilmDAO();
//		ArrayList<Film> searchResult = dao.searchFilmPadination(searchStr, limit, offset);
//		request.setAttribute("films", searchResult);
//		request.setAttribute("searchString", searchStr);
//		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
//		rd.include(request, response);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchStr = request.getParameter("searchStr");
		FilmDB dao = new FilmDB();
		ArrayList<Film> searchResult = dao.searchFilm(searchStr);
		request.setAttribute("films", searchResult);
		request.setAttribute("searchString", searchStr);
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.include(request, response);
	}


}
