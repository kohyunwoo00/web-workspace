package com.kh.mfw.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDetailViewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		HttpSession session = request.getSession();
		
		if(boardNo < 1) {
			session.setAttriute("mesage", "이 장난꾸러기");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		BoardDTO board = new BoardService().findByBoard(boardNo);
		if(board !=null) {
		request.setAttribute("board", board);
		request.getRequestDispatcher("WEB-INF/views/board/detail.jsp").forward(request.response);
		} esle{
			session.setAttribute("message","존재하지 않는 게시글입니다.");
			response.send
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
