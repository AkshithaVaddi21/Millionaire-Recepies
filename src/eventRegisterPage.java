

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class eventRegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String festname=request.getParameter("festname");

		String eventheldat=request.getParameter("eventheldat");
		PrintWriter out=response.getWriter();
	      
		String s=" <!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='ISO-8859-1'>"
						+ "<title>Event Registration</title>"
						+ "<style>"
						+ "body{"
						+ "}"
						+ ".button {"
						+ " height:35px;width:12vw;"
						+ " border-radius: 5px 5px 5px 5px;"
						+ " text-indent: 5%;"
						+ " margin-top:10px;"
						+ "}"
						+ "#submit:hover {"
						+ "  background: #7DCEA0;"
						+ "}"
						+"input:focus {"
						+ " outline: none;"
						+ " outline: 2px solid #27AE60;"
						+ "  box-shadow: 0 0 2px #27AE60;"
						+ "}"
						+ ".header {"
						+ " font-size: 35px;"
						+ "text-transform: uppercase;"
						+ " letter-spacing: 5px;"
						+ " text-align:center;"
						+ " color:#2874A6;"
						+ "	}"
						+ ".description {"
						+ "  font-size: 17px;"
						+ "  letter-spacing: 1px;"
						+ "  line-height: 1.3em;"
						+ " margin: -2px 0 45px;"
						+ " text-align:center;"
						+ "  color:#2874A6;"
						+ "	}"
						+ "	#submit {"
						+ " width:105px;"
						+ " background:#27AE60;"
						+ "	  margin-top:30px;"
						+ " font-family:georgia;"
						+ " font-weight: bold;"
						+ " letter-spacing: 1px;"
						+ " border-radius: 5px 5px 5px 5px;"
						+ "	  cursor: pointer;"
						+ "  color: #FDFCFB;"
						+ "}"
						+ "nav{"
						+ "margin-top:0px;"
						+ "	margin-bottom:20px;"
						+ "	padding-top:40px;"
						+ "text-align:center;"
						+ "font-weight:bold;"
						+ "font-family: georgia;"
						+ "}"
						+ "nav a{"
						+ "position:static;"
						+ "	left:40px;"
						+ "text-decoration:none;"
						+ "font-size:15px;"
						+ "display: inline-block;"
						+ "text-align: center;"
						+ "padding: 14px 16px;"
						+ "text-decoration: none;"
						+ "color:#27AE60;"
						+ "}"
						+ "</style>"
						+ "</head>"
						+ "<body>"
						+ "<div class='header'>"
						+ "	<p>Register For "
						+festname
						+"</p>"
						+ "</div>"
						+ "<div>"
						+ "<nav>"
						+ " <a href='start'>HOME  </a> "
						+ "<a href='dynamic'>EVENTS  </a> "
						+ "</nav>"
						+ "</div>"
						+ "<div>"
						+ "<form method='get' action='registerdata' enctype='multipart/form-data'>"
						+ "	<div class='description'>"
						+ "<p>The Information Provided Below May Be Cross Varified</p>"
						+ "<div>"
						+ "<div class='input'>"
						+ "<input type='text' class= 'button'  name='name1' placeholder='NAME' required > <input type='text' class= 'button' id='location' name='clgname' placeholder='COLLEGE NAME' required><br>"
								+ "	<input type='text' class= 'button' id='cname' name='year' placeholder='GRADUATING YEAR' required> "
										+ "<input type='text' class= 'button'  name='branch' placeholder='BRANCH' required><br>"
												+ "<input type='text' class= 'button' id='phone' name='phone' placeholder='PHONE'  style='width:25vw;' required><br>"
														+ "<input type='text' class= 'button' id='fee' name='mailid' placeholder='EMAIL'  style='width:25vw;' required><br>"
														+"<input type='hidden' name='festname' value='"+festname+"'>"
														+"<input type='hidden' name='eventheldat' value='"+eventheldat+"'>"
																+ "<input type='submit' class='button' id='submit' value='SUBMIT'>"
																		+ "</div>"
																		+ "</form>"
																		+ "</div>"
																		+ "</body>"
																		+ "</html>";
		out.println(s);
		  
	}



}
