package apprepo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NextGenRentServlet
 */
public class NextGenRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig configNextGen; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextGenRentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
List<Application> applications = new ArrayList<>();
        
        // Read data from the file
        String filePath = getServletContext().getRealPath("/data/applications.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Application app = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    app = new Application();
                    app.setName(line.substring(6).trim());
                } else if (line.startsWith("Description:")) {
                    app.setDescription(line.substring(13).trim());
                } else if (line.startsWith("Organization:")) {
                    app.setOrganization(line.substring(14).trim());
                } else if (line.startsWith("Platforms:")) {
                    app.setPlatforms(line.substring(10).trim());
                } else if (line.startsWith("Links:")) {
                    String linksStr = line.substring(7).trim();
                    // Remove brackets and split by commas
                    String[] linksArray = linksStr.substring(1, linksStr.length() - 1).split(", ");
                    app.setLinks(linksArray);
                } else if (line.startsWith("Price:")) {
                    app.setPrice(line.substring(7).trim());
                    applications.add(app);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Set applications attribute to be accessed in JSP
        //request.setAttribute("applications", applications);
        request.getSession().setAttribute("applications", applications);
        // Forward to JSP to display the data
        request.getRequestDispatcher("/displayApplications.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
