

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
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
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
			
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties"); // Load the DB Connection details from the config file
			Properties props = new Properties();
			props.load(in); // Load the DB Connection data onto Properties
			
			DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			out.println("DB Connection Initialized. <br>");// Above line actually establishes the connection.

			//Statement
			Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Create a statement out of connection
			stmt.executeUpdate("insert into productlist(name,price,date_added) values('APPLE MACBOOK', 1500, now())"); // Insert some data using Statement Update
			
			//ResultSet
			ResultSet rst = stmt.executeQuery("select * from productlist"); // Fetch the data from DB
			
			//Iterate through the Resultset Data
			while(rst.next())
			{
				out.println(rst.getInt("ID")+","+rst.getString("name")+"<br>"); // Print the rows in the productlist table
			}
			stmt.close();
			
			out.println("</body></html>");
			conn.closeConnection();
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
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
