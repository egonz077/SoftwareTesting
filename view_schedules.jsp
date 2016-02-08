<jsp:include page="validURL.jsp"/>
<%@ page import="java.util.Collection" %>
<%@ page import="ApplicationLogic.FacadeController" %>
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
</head>
<body>
<jsp:include page="validURL.jsp"/>
<div id="top">
    <jsp:include page="header.jsp"/>
</div>
<div id="left">
    <jsp:include page="left_menu.jsp"/>
</div>
<div id="middle">
    <div id="container">
        <%
            Collection schedules;
            FacadeController fc = new FacadeController();
            //if (session.getValue("sched") == null)
            //{
            //    ScheduleMakerController smc = new ScheduleMakerController();
                schedules = fc.createSchedule(schOpt);
               // session.setAttribute("sched", schedules);
           // }
           // else
           // {
             //   schedules = (Collection) session.getAttribute("sched");
           // }


          //  FormatPage fp = new FormatPage();
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
                <td><h3><a href="view_schedules.jsp?pg=<%=(pg-1)%>">prev</a></h3></td>
                <td align="center"><h3>&nbsp;Page <%=(pg + 1)%> of <%=schedules.size()%>
                </h3></td>
                <td align="right"><h3><a href="view_schedules.jsp?pg=<%=(pg+1)%>">next</a></h3></td>
            </tr>
        </table>
        <%=fc.buildSchedulesPage(schedules, pg)%>
        <%
            } else {
        %>
            <h2>No Schedule Found</h2>
        <%
            }
        %>

    </div>
</div>

</body>
</html>
