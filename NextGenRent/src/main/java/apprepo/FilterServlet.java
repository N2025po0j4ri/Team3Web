package apprepo;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class FilterServlet
 */
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig configNextGen; 
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		configNextGen =  config; 
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		
		return configNextGen;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String query = request.getParameter("query");
		List<Application> appList = (List<Application>) request.getSession().getAttribute("applications");
		List<Application> appFiltered = new ArrayList<>();
		for (int i = 0; i<appList.size(); i++) {
			Application app = appList.get(i);
			if(app.getName().equalsIgnoreCase(query)) {
				appFiltered.add(app);
			}
			
		}
		request.getSession().setAttribute("applications", appFiltered);
	        // Forward to JSP to display the data
	    request.getRequestDispatcher("/displayApplications.jsp").forward(request, response);
		
	}

}
