package com.sol.app.admin;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	  protected void doProcess(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {
		      request.setCharacterEncoding("UTF-8");
		      response.setCharacterEncoding("UTF-8");

		      String target = request.getRequestURI().substring(request.getContextPath().length());
		      Result result = new Result();
		      
		      switch(target) {
		      		case "/admin/login.ad" :
		      		request.getRequestDispatcher("/app/admin/login/admin-login.jsp").forward(request, response);
		      		break;
		      		case "/admin/loginOk.ad" :
		      		System.out.println("여까지가나?");
		      		result = new LoginOkController().execute(request, response);
		      		break;
		      }
		      
		      if(result != null) {
					if(result.isRedirect()) {
						response.sendRedirect(result.getPath());
					}else {
						request.getRequestDispatcher(result.getPath()).forward(request, response);
					}
				}
		      
		      
	  }
}
