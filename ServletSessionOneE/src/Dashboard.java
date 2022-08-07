

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Validate the user using Cookies
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		boolean found = false;
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		cookies  = request.getCookies(); // It will return all the cookies in the browser (100's)
		if(cookies!=null)
			out.println("Total number of cookies in the browser: "+cookies.length);
		if(cookies!=null)
		{
			for(int i=0; i<cookies.length; i++)
			{
				cookie = cookies[i];
				if(cookie.getName().contentEquals("userid") && cookie.getValue()!=null) // Checking whether my cookie with name "userid" is present or not
				{
					out.println("UserID found in the cookie list: "+cookie.getValue() + "<br>");
					found=true;
				}
			}
		}
		
		if(!found)
		{
			out.println("No UserID cookie was found. Dashboard Cannot be displayed now");
		}else
		{
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
