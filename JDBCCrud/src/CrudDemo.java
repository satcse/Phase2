

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
 * Servlet implementation class CrudDemo
 */
@WebServlet("/CrudDemo")
public class CrudDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			
			DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			
			//Insert Statement demo
			Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Acer laptop2', 1211, now())");
			stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Acer laptop3', 12113, now())");
			stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Acer laptop4', 12114, now())");
			stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Acer laptop5', 12115, now())");
			stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Acer laptop6', 12112, now())");
			
			out.println("Insert operation successful<br>");
			
			//Update Statement demo
			stmt.executeUpdate("update eproduct set price=20000 where name='Acer laptop'");
			out.println("Update operation successful<br>");
			
			//Delete Statement demo
			int delCount = stmt.executeUpdate("delete from eproduct where name='New Product12z'");
			out.println("Delete Operation done...deleted New Product12z count:"+delCount);
			out.println("<br><br>");
			//ResultSet Sorting
			ResultSet rst = stmt.executeQuery("select * from eproduct ORDER by name DESC"); // Fetch the data from DB
			
			//Iterate through the Resultset Data
			while(rst.next())
			{
				out.println(rst.getInt("ID")+","+rst.getString("name")+"<br>"); // Print the rows in the productlist table
			}
			stmt.close();
			out.println("</body></html>");
			conn.closeConnection();			
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
