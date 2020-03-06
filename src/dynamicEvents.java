
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class dynamicEvents extends HttpServlet{
	 int m=1;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
      PrintWriter out=res.getWriter();
      String data="man";
    //  event obj=new event();
      						
      try{
          res.setContentType("text/html");
          int j=Event.strLength(); 
      
          String head="<html>"
          		+ "<head>"
          		+ "  <style> "
          		+ " h1{"
          		+ " text-align: center;"
          		+ " letter-spacing: 2px;"
          		+ " font-size:4vw; "
          		+ " color:#0E6655; margin-bottom:1%;"
          		+"width:70%;"
          		+"margin-left:15%; font-family:Georgia;"	
          		+ "  } "
          		+ " </style>"
          		+ " </head>"
          		+ "    <body> "
          		+ "   <h1 style='background-color:#EAF2F8;box-shadow: 0px 0px 4px 3px #bdbdbd;'>Event</h1>"
              +"<center style='text-align:center;color:#27AE60;margin-bottom:2%;'><a href='start'>HOME</a></center> "
          		+ " </body>"
          		+ "</html>";
          out.println(head);
          
          
          while(j!=0){if(Event.exist(m)){
    		  String vx="img?phone="+m;
    	   String s="<html>"
    			   +"<head>"
    			   + "<style>"
    			   + "h1{"
    			   + "text-align: center;"
    			   + "letter-spacing: 2px;"
    			   +"    color:#0E6655;"
    			   + " font-size:50px;"
    			   + "width:70%;	margin-left:15%;"
    			   + "  }    "
    			   + " h2{"
    			   + " letter-spacing: 2px;"
    			   + "font-size:1.7vw;"
    			   + "color:#5FB404 ;"
    			   + "margin-top:0%;		text-align: left;"
    			   + "margin-left: 5%;"
    			   +"	display:inline-block;font-family:Georgia;"
    			   + "} "
    			   + "h3{"
    			   + " text-align: center;"
    			   + " margin-top:2vw;"
    			   + "  font-size:2.5vw;font-family:Georgia;"
    			   + "color:#6C3483; letter-spacing: 2px;"
    			   +"background-color:#EAF2F8;"
    			   + "}"
    			   + "img{"
    			   + "  width: 90%; "
    			   + "   height:30vw;"
    			   +"text-align: center;"
    			   + "    } "
    			   + "#button{ "
    			   + " float:center;  "
    			   + "	margin-top:1vw;"
    			   + "     } "
    			   +"#sty{"
    			   +"border-style: solid;"
    			  +"border-color: #E6E6E6;"
    			   +"width:40%;margin-left:30%;"
    			  +"box-shadow: 0px 0px 4px 3px #bebebe;}"
    			   + "  .moreinfo {"
    			   + "  width:7vw;"
    			   + " height: 2.6vw;"
    			   + " background:#27AE60;"
    			   + "    font-family:Georgia; "
    			   + "  font-weight: bold;"
    			   + "  letter-spacing: 1px;font-size:1vw;"
    			   + " border-radius: 5px 5px 5px 5px;"
    			   + "  cursor: pointer;"
    			   + " color: #FDFCFB; "
    			   + "} "
    			   + "  </style>"
    			   + " </head>"
    			   + "   <body>"
    			   + " <div id='sty'> "
    			   +"<div>"
    			   + "	<h3 name=p"
    			   +m
    			   +">"
    			   + Event.eventData(m,2)
    			   +"</h3>"
    			   +"</div>"
    			   +"<div>"
    			   + "<h2>"
    			   +Event.eventData(m,5)
    			   +"</h2>  "
    			   + " </div> "
    			   +"<div style='text-align:center'>"
    			   + " <img src="+vx+" name='test'>"
    			   + "</div> "
    			   +"<div style='margin-left:78%'>"
    			   + "   <form action='ret3' method='get'>"
    			   +"<input type='hidden' name='m'"+" value="+m+">"
   	      		  +"<input type='hidden' name='festname' value='"+Event.eventData(m,2)+"'>"
   	      		  +"<input type='hidden' name='aboutevent' value='"+Event.eventData(m,4)+"'>"
   	      		  +"<input type='hidden' name='location' value='"+Event.eventData(m,5)+"'>"
   	      		  +"<input type='hidden' name='contact' value='"+Event.eventData(m,7)+"'>"
   	      		  +"<input type='hidden' name='fee' value='"+Event.eventData(m,8)+"'>"
   	      		  +"<input type='hidden' name='date' value='"+Event.eventData(m,9)+"'>"
   	      		  +"<input type='hidden' name='time' value='"+Event.eventData(m,10)+"'>"
   	      		  +"<input type='hidden' name='organiser' value='"+Event.eventData(m,6)+"'>"
     			   + "<input type='submit' class='moreinfo' id='button' value='More Info'> "
    			   	+ "   </form> "
    			   	+ "	</div>"
    			   	+"</div>"
    			   	+ " </body>"
    			   	+ " </html>";
          out.append(s);
          out.append(Integer.toString(m));
          j--;
          m++;
          }else
          {
        	  m++;
          }
                 }
          if(j==0)
          {
        	   j=Event.strLength(); 
          }
       if(m>Event.strLength())
       {
    	   m=1;
       }
      }
      catch(Exception e){
        out.println(e);
      }
  }
}

class Event
{
    public static String eventData(int uname,int col) 
    {
     boolean st =false;
    String s="";
     try{
    	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event WHERE Id=? ");
statement.setInt(1,uname);
	
   ResultSet rs=statement.executeQuery();
	st=rs.next();
	s=rs.getString(col);
	

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return s;  	
 }   
    
    public static int strLength() 
    {int len=0;
     try{
    	 
	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event");

	
   ResultSet rs=statement.executeQuery();
	while(rs.next()){
		len++;
	}
	

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return len;  	
 }   
    
    public static boolean exist(int id) 
    {
     boolean st =false;
     try{

	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event WHERE Id=?");
statement.setInt(1,id);
	
   ResultSet rs=statement.executeQuery();
	st=rs.next();

     }catch(Exception e)
     {
         e.printStackTrace();
     }
return st;
                       
 }   
}
