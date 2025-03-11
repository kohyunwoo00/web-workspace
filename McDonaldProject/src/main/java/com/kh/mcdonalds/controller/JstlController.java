package com.kh.mcdonalds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mcdonalds.model.dto.UserDTO;
import com.kh.mcdonalds.model.service.UserService;

/**
 * Servlet implementation class JastlController
 */
@WebServlet("/jstl")
public class JstlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JstlController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int point = 500;
		request.setAttribute("pont", point);
		
		String[] colors = {"red","blue", "orange", "yellow", "yellowgreen", "greenyellow", "green"};
		request.setAttribute("colors", colors);
		
		// TB_USER가지고 할 것
		List<UserDTO> list = new UserService().findAll();
		
		request.setAttribute("users", list);
		request.setAttribute("msg", "리스트가 null아니면 조회성공");
		request.getRequestDispatcher("/WEB-INF/views/jstl/jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
