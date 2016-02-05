<%@ page import="ApplicationLogic.Authentication" %>
<%--
  Created by IntelliJ IDEA.
  User: alain
  Date: Dec 2, 2006
  Time: 11:55:28 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loginData" class="ApplicationLogic.LoginOptions" scope="session"/>
<jsp:setProperty name="loginData" property="*"/>
<html>
<head><title>Simple jsp page</title></head>
<body>
<%
    Authentication smc = new Authentication();
   
    if (smc.isLoginValid(loginData.getPantherID(), loginData.getPassword()))
    {
        // Valid login
        session.setAttribute("authorized", "yes");
        response.sendRedirect("manage.jsp");
    }
    else
    {
        // Invalid login
        session.setAttribute("authorized", "no");
        response.sendRedirect("login.jsp?msg=Invalid Login Information. Please reenter your login information.");
    }
   
 
%>
</body>
</html>