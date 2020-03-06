
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    


public class registeredUserDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 String festname = request.getParameter("festname");
		 String eventheldat = request.getParameter("eventheldat");
        String studentname = request.getParameter("name1");
        String clgname = request.getParameter("clgname");
        String year = request.getParameter("year");
        String branch = request.getParameter("branch");
	String phone=request.getParameter("phone");
	String mailid=request.getParameter("mailid");
	    PrintWriter out = response.getWriter();
       int i=usersRegistartion.eventRegForm(festname,eventheldat,studentname,clgname,year,branch,phone,mailid);
		if(i>0)
		{
			out.println("Registered Successfully");
  RequestDispatcher rs = request.getRequestDispatcher("start");
               rs.include(request, response);

try{usersRegistartion.send(mailid,studentname,festname);
}
catch(Exception ae)
{
out.println("error");
}
			
		}
		else
			out.println("exception  ");
		
    }  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}

 class usersRegistartion
 {
public static void send(String to,String name,String eventname){  
String from="vardhaman1317@gmail.com";
String password="akshitha123";
String msg="Hi "+name+" thanks for your interest to be part of this event";

          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(eventname);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  


	
     public static int eventRegForm(String festname,String eventheldat,String studentname,String clgname,String year,String branch,String phone,String mailid) 
     {  int rs=0;
      try{
		 
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("INSERT INTO eventRegisters VALUES(?,?,?,?,?,?,?,?,?)");
statement.setString(1,null);

statement.setString(2,festname);
statement.setString(3,eventheldat);

statement.setString(4,studentname);

statement.setString(5,clgname);
statement.setString(6,year);
statement.setString(7,branch);
statement.setString(8,phone);
statement.setString(9,mailid);



    rs=statement.executeUpdate();
 
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 return rs;  
            
  }   
	}

