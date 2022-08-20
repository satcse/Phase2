package com.ecommerce;

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
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			List<EProduct> list = session.createQuery("from EProduct").list();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
              
            out.println("<b>Component Mapping</b><br>");
            for(EProduct p:list)
            {
            	out.println("ID: "+String.valueOf(p.getID())+" ,Name: "+p.getName()+" ,Price:"+String.valueOf(p.getPrice())+", Date Added: "+p.getDateAdded().toString()+"<br>");
            	ProductParts parts = p.getParts();
            	out.println("Parts= "+parts.getCpu()+" ,"+parts.getRam()+" ,"+parts.getHdd()+"<br>");
            	out.println("<hr>");
            }

            session.close();    
            out.println("</body></html>");
		}catch(Exception e)
		{
			e.printStackTrace();
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
