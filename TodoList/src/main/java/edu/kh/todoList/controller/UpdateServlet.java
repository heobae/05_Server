package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 서비스 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 요청 시 전달받은 파라미터 받아오기
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			// 알맞은 서비스 호출 후 결과 반환
			int result = service.todoUpdate(todoNo);
			
			// session scope 객체 얻어오기
			HttpSession session = req.getSession();
									
			// result 값이 0보다 크다 == 변경 성공 , 아니면 실패
			// -> 원래 보고 있던 상세 페이지로 redirect
			// -> message "완료 여부가 변경되었습니다!" alert
			if(result > 0) {
				session.setAttribute("message", "todo가 수정되었습니다!");
				resp.sendRedirect("/todo/detail?todoNo=" + todoNo);
				return;
			}
									
			// 변경 실패 시
			// -> 메인페이지로 redirect
			// -> message "todo가 존재하지 않습니다" alert
			session.setAttribute("message", "todo가 존재하지 않습니다");
			resp.sendRedirect("/");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
