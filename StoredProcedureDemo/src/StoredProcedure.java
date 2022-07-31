

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
 * Servlet implementation class StoredProcedure
 */
@WebServlet("/StoredProcedure")
public class StoredProcedure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoredProcedure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			//Create a Out object from the response.
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			//Load the Database Properties and save it to the props objects
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			
			//Establish the Database connection here
			DBConnection conn = new DBConnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			
			//Stored Procedure
			/*
			 * CREATE PROCEDURE ecommerce.sp_product(IN pname varchar(100), IN pprice
			 * decimal(10,2)) INSERT INTO ecommerce.eproduct(name,price) VALUES(pname,
			 * pprice)
			 */

			//Invoke the Callable Statement - Stored Procedure.
			CallableStatement stmt = conn.getConnection().prepareCall("{call sp_product(?,?)}"); // Calling the stored procedure called sp_product with CallableStatement.
			stmt.setString(1, "Asus ROG");
			stmt.setBigDecimal(2, new BigDecimal(2100.50)); // Set the value for the parameters.
			
			stmt.executeUpdate(); // Invoke the Stored Procedure.
			
			out.println("Stored Procedure has been executed!<br>");
			stmt.close();
			
			out.println("</body></html>");
			conn.closeConnection();			
		}catch (ClassNotFoundException | SQLException e)
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
