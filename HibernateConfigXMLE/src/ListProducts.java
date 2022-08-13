
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.EProduct;
import com.ecommerce.HibernateUtil;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * Workflow 
		 * 1.) First, hibernate.cfg.xml --> Loads into Hibernate Util 
		 * 2.) and the HibernateUtil's static block would have got executed.
		 * 3.) Eproducts POJO and Eproduct.hbm.xml is mapped.
		 * 4.) index.html --> Web.xml 
		 * 5.) Web.xml --> ListProducts Servlet 		 
		 * 6.) In the doGet of ListProductsServlet, Session is created. 		
		 * 7.) The query is executed and the results of the query is iterated and printed through.
		 */

		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			out.println("Hibernate Session opened.<br>");

			List<EProduct> list = session.createQuery("from EProduct").list();

			
			out.println("<b> Product Listing</b><br>");
			for (EProduct p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ",Price: "
						+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
			}
			session.close();
			out.println("Hibernate Session Closed.<br>");
			out.println("</body></html>");
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
