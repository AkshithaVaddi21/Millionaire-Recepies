

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


public class mainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String log="";
		HttpSession session=request.getSession(false);
		if(session!=null){
			
             log="<a class='SignIn' href='logout'>LOGOUT </a>";
		}
		else
		{ 
			log="<a class='SignIn' href='login.html'>LOGIN </a>";
		}
		
		PrintWriter out = response.getWriter();
		String s="<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='ISO-8859-1'>"
				+ "<meta name='viewport' content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no'>"
				+ "	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>"
				+ "<meta name='HandheldFriendly' content='true'>"
				+ "<script type='text/javascript'>"
				+ "var slideimages = new Array() ;"
				+colleges.eventPics() 
						+ "</script>"
						+ "<style>"
						+ ".heading{"
						+ "margin-left:20%;"
						+ "	width:60%;"
						+ "color:#2874A6;"
						+ "text-align:center;"
						+ "font-size:4.5vw;"
						+ "font-family: Georgia;"
						+ "font-weight:bold;"
						+ "padding-top:2%;"
						+ "margin-top:0px;"
						+ "padding-bottom:1%;"
						+ "margin-bottom:0px;"
						+ "letter-spacing:2px;"
						+ "box-shadow: 10px 10px 10px #EAF2F8;"
						+ "}"
						+ "#total{"
						+ "background-color:#EAF2F8;"
						+ "height:60px;"
						+ "	border:none;"
						+ "}"
						+ ".name{"
						+ "float:left;"
						+ "padding-top:10px;"
						+ "padding-left:2%;"
						+ "}"
						+ ".user{"
						+ "float:right;"
						+ "	padding-top:1.5%;"
						+ "padding-right:2%;"
						+ "}"
						+ "a:link{"
						+ "text-decoration:none;"
						+ "}"
						+ ".SignIn{"
						+ "	color:#138D75;"
						+ "font-size:1vw;"
						+ "font-weight:bold;"
						+ "font-family: Georgia;"
						+ "}"
						+ ".Register{"
						+ "color:#138D75;"
						+ " font-family: Georgia;"
						+ "font-size:1vw;"
						+ "font-weight:bold;"
						+ "margin-top:5px;"
						+ "}"
						+ ".website{"
						+ "font-size:30px"
						+ "}"
						+ "nav{"
						+ "	margin-top:0px;"
						+ "	margin-bottom:2%;"
						+ "padding-top:2%;"
						+ "text-align:center;"
						+ "font-weight:bold;"
						+ " font-family: Georgia;"
						+ "}"
						+ "nav a{"
						+ "position:static;"
						+ "left:40px;"
						+ "text-decoration:none;"
						+ "font-size:1.1vw;"
						+ "display: inline-block;"
						+ "text-align: center;"
						+ "padding: 1% 1%;"
						+ "text-decoration: none;"
						+ "color:#27AE60;"
						+ "}"
						+ ".name{"
						+ "font-size:1vw;"
						+ "color:#138D75;"
						+ "font-family: Georgia;"
						+ "}"
						+ "div.list1{"
						+ "float:left;"
						+ "}"
						+ "div.list3{"
						+ "float:right;"
						+ "	position:relative;"
						+ "bottom:4px;"
						+ "}"
						+ "center{"
						+ "color:#566573;"
						+ "}"
						+ ".subtitle{"
						+ "text-align:center;"
						+ "margin-top:3%;"
						+ "color:#808B96;"
						+ "text-transform:uppercase;"
						+ "font-family: Georgia;"
						+ "letter-spacing:1px;"
						+ " font-size:0.9vw;"
						+ "}"
						+ "</style>"
						+ "</head>"
						+ "<body>"
						+ "<div id='total'>"
						+ "<div class='name'>"
						+ "&#9742; +91 9908061177 </br> &#9993;"
						+ "millionairerecepies@gmail.com"
						+ "</div>"
						+ "<div class='user'>"
						+ log
						+ "</div>"					
						+ "</div>"						
						+ "<div >"
						+ "<p class='heading'>Millionaire Recepies</p>"
						+ "<p class='subtitle'>Know  The  Events  Happening  Around  You</p>"
						+ "<nav>"
						+ " <a href='dynamic'>EVENTS </a> "
						+ "<a href='usercheck'>PUBLISH AN EVENT </a> "
						+ "<a href='About.html'>ABOUT  </a>"
						+ "</nav>"
						+ "<div>"
						+ "<div class='list1' style='width:22%;'>"
						+ "<p style='font-size:1.4vw; color:#616A6B; text-align:center;width:90%;font-family: Georgia;'>List Of Organizations</p>"
						+ "<marquee bgcolor='' scrollamount='4' direction='up' loop='true' height='300' width='90%'>"
						+ "<center>"
						+colleges.collegeNames(1)
						+ "</center>"
						+ "</marquee>"
						+ "</div>"
						+ "<div class='list1' style='width:56%;'>"
						+ "<img src=slideimages[0].src id='slide' width='100%' height='450' class='img' />"
						+ "<script type='text/javascript'>"
						+ "var step=0;"
						+ "function slideit(){"		
						+" if (!document.images)"
 						+" return ;"
						+"document.getElementById('slide').src = slideimages[step].src;"
						+ " if (step<4)"
						+ "  step++;"
						+ "	 else"
						+ "  step=0;"
						+ "	 setTimeout('slideit()',3000);"
						+ "}"
						+ "slideit();"
						+ "</script>"
						+ "</div>"
						+ "<div class='list3' style='position:relative;width:22%'>"
						+ "<p style='font-size:1.4vw; color:#616A6B; text-align:center;	font-family: Georgia;'>Types Of Events</p>"
								+ "<marquee bgcolor='' scrollamount='4' direction='up' loop='true' height='300' width='90%'>"
										+ "<center>"
										+colleges.collegeNames(2)
										+ "	</center>"
														+ "</marquee>	"
														+ "</div>"
														+ "	</div>"
														+ "	</body>"
														+ "	</html>"
														+ "	</html>";
		out.println(s);
	}
}
	
class colleges
{
    public static String collegeNames(int i) 
    {
    String s="";
     try{
    	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	
	
	if(i==1){
PreparedStatement statement = con.prepareStatement("SELECT DISTINCT orgName FROM event");
	ResultSet rs=statement.executeQuery();
	while(rs.next()){
	s=s+"<p style='font-size:1.2VW;font-family: Georgia;' ><font>"+rs.getString("orgName")+"</font></p>";
	
	}}
	else{
PreparedStatement statement = con.prepareStatement("SELECT DISTINCT EventType FROM event");
	ResultSet rs=statement.executeQuery();
	while(rs.next()){
	s=s+"<p style='font-size:1.2VW;font-family: Georgia;' ><font>"+rs.getString("EventType")+"</font></p>";

	}
	}
	

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return s;  	
 }  

public static String eventPics() 
    {
    String s="";
     try{
    	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event");
	ResultSet rs=statement.executeQuery();
	int m=0;
	String vx="";
	while(rs.next()){
		  vx="img?phone="+rs.getString("Id");
	s=s+"slideimages["+m+"] = new Image();"+ "slideimages["+m+"].src ='"+vx+"';";
	m++;
	}

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return s;  	
 }  

 }