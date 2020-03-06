
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

@MultipartConfig(maxFileSize=16177215)

/**
 * Servlet implementation class Publish
 */
public class publishEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		
	String event = request.getParameter("event");
        String type = request.getParameter("eventtype");
	String info = request.getParameter("info");
        String cname = request.getParameter("cname");
        String phone = request.getParameter("phone");
	String date=request.getParameter("date");
	String time=request.getParameter("time");
	String location=request.getParameter("location");
	String fee=request.getParameter("fee");
InputStream inputStream=null;
Part filePart=request.getPart("photo");
inputStream=filePart.getInputStream();
       
       int i=PublishForm.addUser(event,info,location,phone,fee,date,time,cname,inputStream,type);
		if(i>0)
		{
			out.println("Published successfull.");
			  RequestDispatcher rs = request.getRequestDispatcher("/start");
                 rs.include(request, response);
      
		}
		else
			out.println("exception  ");
		
    
	}
	
	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

	

}

 class PublishForm
 {

	
     public static int addUser(String event,String info,String location,String phone,String fee,String date,String time,String cname,InputStream inputStream,String ctype) 
     {  int rs=0;
      try{
		 
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("INSERT INTO event VALUES(?,?,?,?,?,?,?,?,?,?,?)");
statement.setString(1,null);
statement.setString(2,event);

statement.setString(3,ctype);
statement.setString(4,info);

statement.setString(5,location);
statement.setString(6,cname);
statement.setString(7,phone);
statement.setString(8,fee);
	
statement.setString(9,date);
statement.setString(10,time);

statement.setBlob(11,inputStream);


    rs=statement.executeUpdate();
 
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 return rs;  
            
  }   
	}

