<jsp:include page="validURL.jsp"/>
<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%--
  Created by IntelliJ IDEA.
  User: alain
  Date: Dec 2, 2006
  Time: 11:54:43 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<div id="center_box" align="center">
    <table width="100" cellspacing="15">
        <tr>
          <td align="center" valign="middle" nowrap="nowrap"><a href="create_schedule.jsp">Create Schedule </a></td>
        </tr>
        <tr>
            <td align="center" valign="middle" nowrap="nowrap"><a href="#">Your Saved Schedules </a></td>
        </tr>
        <tr>
          <td align="center" valign="middle" nowrap="nowrap"><a href="#">Balance</a></td>
        </tr>
    </table>
  <br/>
  <br/>
  <br/>
</div>
<div id="footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
