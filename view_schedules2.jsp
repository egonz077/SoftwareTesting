<jsp:include page="validURL.jsp"/>
<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%@ page import="java.util.Collection" %>
<%@ page import="ApplicationLogic.ScheduleMakerController" %>
<%@ page import="ApplicationLogic.FormatPage" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="schOpt" class="ApplicationLogic.ScheduleOptions" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Database Project</title>
    <link rel="stylesheet" href="css/fouc.css" type="text/css" media="all"/>
    <style type="text/css" media="all">
        @import url( "css/03_3columnplustopbox.css" );
        @import url( "css/tabs.css" );
    </style>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
    <meta name="MSSmartTagsPreventParsing" content="TRUE"/>
    <meta http-equiv="expires" content="-1"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta name="robots" content="all"/>
    <meta name="author" content="Owen Briggs"/>
    <meta name="description" content="Workarounds for CSS browser issues."/>
    <script type="text/javascript" xml:space="preserve">
        <!--
           function send(pg) {
           document.getElementById("pg").value = pg;
            document.getElementById("form1").submit();
            }
        -->
    </script>
</head>
<body>

<div id="top">
    <jsp:include page="header.jsp"/>
</div>
<div id="left">
    <jsp:include page="left_menu.jsp"/>
</div>
<div id="middle">
    <div id="container">
        <form name="form1" id="form1" action="view_schedules2.jsp" method="post">
            <input type="hidden" name="term" id="term" value="<%=request.getParameter("term")%>">
            <input type="hidden" name="course1" id="course1" value="<%=request.getParameter("course1")%>">
            <input type="hidden" name="course2" id="course2" value="<%=request.getParameter("course2")%>">
            <input type="hidden" name="course3" id="course3" value="<%=request.getParameter("course3")%>">
            <input type="hidden" name="course4" id="course4" value="<%=request.getParameter("course4")%>">
            <input type="hidden" name="course5" id="course5" value="<%=request.getParameter("course5")%>">
            <input type="hidden" name="course6" id="course6" value="<%=request.getParameter("course6")%>">
            <input type="hidden" name="campus" id="campus" value="<%=request.getParameter("campus")%>">
            <input type="hidden" name="pg" id="pg" value="<%=request.getParameter("pg")%>">
        <%
            Collection schedules;
            ScheduleMakerController smc = new ScheduleMakerController();
            Collection<String> courses = new ArrayList<String>();
            if(request.getParameter("course1") != null && !request.getParameter("course1").trim().equals(""))
                courses.add(request.getParameter("course1"));
            if(request.getParameter("course2") != null && !request.getParameter("course2").trim().equals(""))
                courses.add(request.getParameter("course2"));
            if(request.getParameter("course3") != null && !request.getParameter("course3").trim().equals(""))
                courses.add(request.getParameter("course3"));
            if(request.getParameter("course4") != null && !request.getParameter("course4").trim().equals(""))
                courses.add(request.getParameter("course5"));
            if(request.getParameter("course3") != null && !request.getParameter("course5").trim().equals(""))
                courses.add(request.getParameter("course5"));
            if(request.getParameter("course6") != null && !request.getParameter("course6").trim().equals(""))
                courses.add(request.getParameter("course6"));
            String days = "";
        String SPDays = "";
            if (request.getParameter("m") != null && !request.getParameter("m").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("t") != null && !request.getParameter("t").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("w") != null && !request.getParameter("w").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("th") != null && !request.getParameter("th").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("f") != null && !request.getParameter("f").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("s") != null && !request.getParameter("s").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";
            if (request.getParameter("su") != null && !request.getParameter("su").trim().equals(""))
                SPDays += "0";
            else
                SPDays += "1";

            schedules = smc.createSchedule(request.getParameter("term"), courses, request.getParameter("campus"), SPDays);

            FormatPage fp = new FormatPage();
            int pg = 0;
            try
            {
                if (request.getParameter("pg") == null || request.getParameter("pg").equals("") || request.getParameter("pg").equals("0"))
                    pg = 0;
                else if (Integer.parseInt(request.getParameter("pg")) < 0)
                    pg = 0;
                else if (Integer.parseInt(request.getParameter("pg")) >= schedules.size())
                    pg = schedules.size() - 1;
                else
                {

                    pg = Integer.parseInt(request.getParameter("pg"));

                }
            }
            catch (NumberFormatException e)
            {
                pg = 0;
            }

        %>
        <%
            if(schedules.size() > 0) {
        %>
        <table width="80%" align="center">
            <tr>
                <td><h3><a href="javascript:send(<%=(pg-1)%>)">prev</a></h3></td>
                <td align="center"><h3>&nbsp;Page <%=(pg + 1)%> of <%=schedules.size()%>
                </h3></td>
                <td align="right"><h3><a href="javascript:send(<%=(pg+1)%>)">next</a></h3></td>
            </tr>
        </table>
        <%=fp.buildSchedulesPage(schedules, pg)%>
        <%
            } else {
        %>
            <h2>No Schedule Found</h2>
        <%
            }
        %>
        </form>

    </div>
</div>

</body>
</html>