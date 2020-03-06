import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;


public class login extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

       
Cookie firstName = new Cookie(uname,uname);
      Cookie lastName = new Cookie(uname+"_pass",pass);

      // Set expiry date after 24 Hrs for both the cookies.
      firstName.setMaxAge(60*60*24); 
      lastName.setMaxAge(60*60*24); 

      // Add both the cookies in the response header.
      response.addCookie( firstName );
      response.addCookie( lastName );


        PrintWriter out = response.getWriter();
        
        
        if(Validate.checkUser(uname,pass))
        {
		out.println("login successful..Now You can Publish Your Event");
        	HttpSession session=request.getSession();  
            session.setAttribute("name",uname);  
            RequestDispatcher rs = request.getRequestDispatcher("start");
            rs.include(request, response);
      
}
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}

class Validate
 {
     public static boolean checkUser(String uname,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM logindata WHERE username=? and password=?");
statement.setString(1,uname);
statement.setString(2,pass);
	
    ResultSet rs=statement.executeQuery();
	st=rs.next();
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
return st;
                        
  }   
}
