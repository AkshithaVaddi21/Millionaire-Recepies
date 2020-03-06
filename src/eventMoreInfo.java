

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class eventPage
 */
public class eventMoreInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
		  String m=request.getParameter("m");
		  String festname=request.getParameter("festname");
		  String aboutevent=request.getParameter("aboutevent");
		  String location=request.getParameter("location");
		  String contact=request.getParameter("contact");
		  String fee=request.getParameter("fee");
		  	String date=request.getParameter("date");
		  	String time=request.getParameter("time");
		  	String organiser=request.getParameter("organiser");
		  			
		  String x=m;
		  String v="img?phone="+x;

	      PrintWriter out = response.getWriter();
	      // Actual logic goes here.
		  String p="<html>"
		  		+ " <head>"
		  		+ "<style>"
		  		+ " h1{"
		  		+ "text-align: center;"
		  		+ "  letter-spacing: 2px;"
		  		+ "   font-size:3.5vw;"
		  		+ "  color:#5B2C6F;"
		  		+ "width:70%;font-family:Georgia;"
		  		+ "margin-left:15%;text-transform: uppercase;"
		  		+ "  } "
		  		+ "#sty{"
		  		+ "border-style: solid;"
		  		+ "	border-color: #F4F6F6;"
		  		+ "	float:right;"
		  		+ "	height:49%;"
		  		+ "	width:48%;"
		  		+ "	}"
		  		+ "  .moreinfo {"
		  		+ " width:auto;"
		  		+ "  height: 2.6vw;"
		  		+ " background:#27AE60;"
		  		+ "font-family:Georgia;"
		  		+ "font-weight: bold;"
		  		+ "letter-spacing: 1px;"
		  		+ " border-radius: 5px 5px 5px 5px;"
		  		+ "cursor: pointer;"
		  		+ " color: #FDFCFB;font-size:1vw;"
		  		+ "}"
		  		+ "   #button{"
		  		+ "	margin-top:30px;"
		  		+ "margin-left:45%;"
		  		+ "    }"
		  		+ "</style>"
		  		+ "</head>"
		  		+ "<body>"
		  		+ "<h1 style='background-color:#F5EEF8;box-shadow:0px 0px 4px 3px #bdbdbd;'>"
		  		+festname
		  		+"</h1>"
		  		+ "<div>"
		  		+ "<spam style='font-size:2.1vw;box-shadow:0px 0px 4px 3px #bdbdbd;font-family:Georgia;background-color:#F5EEF8  ;'>About The Event:</span>"
		  		+ "<p style='margin-left:50px;font-size:1.8vw;font-family:Georgia;color:#0E6655;'>"
		  		+aboutevent
		  		+"</p>"
		  		+ "<div>"
		  		+ "<div style='display:inline-block;width:50%;'>"
		  		+ "<img src="+v+" alt='hii' width='98%' height='53%' style='border:solid;border-color:#F4F6F6  ;'>"
		 + "</div>"
		  		+ "<div id='sty' style='font-family:Georgia;padding-top:30px;font-size:2vw;background-color:#F5EEF8;'>"
		  		+ "<div style='margin-top:10px;margin-left:40px;'>"
		  		+ "	Venue : "+location
		  		+ "</div>"
		  		+ "<div style='margin-top:10px;margin-left:40px;color:#17202A;'>"
		  		+ "	Organiser Name : "+organiser
		  		+ "</div>"
		  		+ "<div style='margin-top:10px;margin-left:40px;color:#17202A;'>"
		  		+ "Phone : "+contact
		  		+ "</div>"
		  		+ "<div style='margin-top:10px;margin-left:40px;color:#17202A;'>"
		  		+ "Date : "+date
		  		+ "</div>"
		  		+ "<div style='margin-top:10px;margin-left:40px;color:#17202A;'>"
		  		+ "Time : "+time
		  		+ "</div>"
		  		+ "<div style='margin-top:10px;margin-left:40px;color:#17202A;'>"
		  		+ "Registration Fee : "+fee
		  		+ "</div>"
		  		+ "</div>"
		  		+ "</div>"
		  		+ "<div style='float:center'>"
		  		+"<form action='register' method='get'>"
		  		+"<input type='hidden' name='festname' value='"+festname+"'>"
		  		+"<input type='hidden' name='eventheldat' value='"+location+"'>"
		  		+ "	<input type='submit' class='moreinfo' id='button' value='Register for event'>"
		  		+"</form>"
		  		+ "</div>"
		  		+ "</div>"
		  		+ "</body>"
		  		+ "</html>";


	      
	      out.println(p);
	}



}
