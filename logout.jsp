<%
    session.setAttribute("authorized", "no");
    session.invalidate();
    response.sendRedirect("login.jsp");
%>