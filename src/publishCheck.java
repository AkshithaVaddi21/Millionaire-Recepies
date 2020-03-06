

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class publishCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		if(session!=null){
			 RequestDispatcher rs = request.getRequestDispatcher("/publish.html");
                         rs.forward(request, response);
		}
		else
		{ 
			PrintWriter out = response.getWriter();
	       		   out.println("plz login");
			  RequestDispatcher rs = request.getRequestDispatcher("/login.html");
                          rs.include(request,response);
		}
	}


}
