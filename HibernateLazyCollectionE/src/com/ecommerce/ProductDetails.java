package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            
             
            List<EProduct> list = session.createQuery("from EProduct").list();
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             out.println("<b>Product Listing</b><br>");
             for(EProduct p: list) {
                     
            	 //Print the EProduct Table data
            	 	 out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                     ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());
                     
            	 //Print the corresponding Color options	 
                     List<Color> colors = p.getColors(); //Lazy Fetch will happen
                     out.println("<br>Colors: <ul>");
                     for(Color c:colors)
                     {
                    	 out.print("<li>"+c.getName() + "</li>");
                     }
                     out.println("</ul>");
                     out.println("<hr>");
                     
                 //Print the corresponding ScreenSize options
                     Collection<ScreenSizes> sizes = p.getScreenSizes();
                     out.println(",<br> Screen Sizes: <ul>");
                     for(ScreenSizes s: sizes)
                     {
                    	 out.println(s.getSize() + "&nbsp;");
                     }
                     out.println("</ul>");
                     out.println("<hr>");
                     
                //Print the corresponding OS options
                     Set<OS> os = p.getOs();
                     out.println("<br> OS: <ul>");
                     for(OS s: os)
                     {
                    	 out.println(s.getName() + "&nbsp;");
                     }
                     out.println("</ul>");
                     out.println("<hr>");
                     
                //Print the corresponding Finance options
				/*
				 * Map finances = p.getFinance(); out.println("<br> FINANCE OPTIONS: <ul>");
				 * if(finances.get("CREDITCARD")!=null) { Finance f =(Finance)
				 * finances.get("CREDITCARD"); out.println(f.getName() + " &nbsp;"); }
				 * if(finances.get("BANK")!=null) { Finance f =(Finance) finances.get("BANK");
				 * out.println(f.getName() + " &nbsp;"); } out.println("</ul>");
				 * out.println("<hr>"); out.println("<hr>");
				 */
             	}
             session.close();
             out.println("</body></html>");
             }catch (Exception e) {
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
