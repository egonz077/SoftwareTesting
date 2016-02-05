<%
    try {
    String authorized = (String) session.getAttribute("authorized");

    if (authorized.equals("no"))
    {
%>
<jsp:forward page="login.jsp"/>
<%
    }
    } catch(Exception e) {
%>
<jsp:forward page="login.jsp"/>
<%
        
    }

%>