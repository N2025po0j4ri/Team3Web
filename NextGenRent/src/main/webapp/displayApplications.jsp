<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="apprepo.Application"%> 
<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Repository</title>
</head>
<body>
    <form action="FilterServlet" method="post">
        <input type="text" name="query" value="${query}" placeholder="Filter...">
        <input type="submit" value="Filter">
    </form>    
    <form action="FilterServlet" method="post">
    	<input type="submit" value="SortByAppName">
    </form>
    <h1>Application Repository</h1>
    <form method = "GET" action = "NextGenRentServlet" >
        
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Organization</th>
            <th>Platforms</th>
            <th>Links</th>
            <th>Price</th>
        </tr>
         
        <%ArrayList<Application> appList =  
            (ArrayList<Application>)session.getAttribute("applications"); 
        for(Application app:appList){%>
     
            <tr>
          
                <td><%=app.getName()%></td>
                <td><%=app.getDescription()%></td>
                <td><%=app.getOrganization()%></td>
                <td><%=app.getPlatforms()%></td>
                <td><%=app.getLinks()%></td>
                <td><%=app.getPrice()%></td>
            </tr>
           <%}%> 
        
    </table>
    </form>
</body>
</html>
