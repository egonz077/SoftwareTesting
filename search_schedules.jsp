<jsp:include page="validURL.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="schOpt" class="ApplicationLogic.ScheduleOptions" scope="session"/>
<jsp:setProperty name="schOpt" property="*"/>
<HTML><head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Schedules</title>
</head>

<body>
<%
    session.removeAttribute("sched");
    session.removeValue("sched");
%>
<jsp:forward page="view_schedules.jsp"/>
<A HREF="view_schedules2.jsp">Continue</A>

</body>
</html>
