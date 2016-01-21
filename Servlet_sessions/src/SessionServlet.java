

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
	// TODO Auto-generated method stub
	HttpSession session = request.getSession(true);
	response.setContentType("text/plain");
	PrintWriter out = response.getWriter();
	Integer counter = new Integer(0);
	if (session.isNew()) {
	out.println("New user!");
	}
	else
	
	{
	out.println("Welcome back!");
	counter = (Integer)session.getAttribute("counter");
	if (counter != null) {
	counter = new Integer(counter.intValue() + 1);
	}
	}
	session.setAttribute("counter", counter);
	out.println(session.getId());
	out.println("Creation Time: " + new Date(session.getCreationTime()));
	out.println("Time of Last Access: "+ new Date(session.getLastAccessedTime()));
	out.println("Counter: " + counter);
	}

}
