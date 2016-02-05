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
<div id="top">
<table width="100%">
  <tr>
    <td><img src="images/logo.jpg" alt="Schedule Maker" width="179" height="129" /></td>
    <td align="right" valign="bottom"></td>
  </tr>
</table></div>
<div id="center_box" align="center">
    <div align="center">
        <%
            if(request.getParameter("msg") != null)
                out.println(request.getParameter("msg"));
        %></div>
    <form action="loginValidation.jsp" method="post">
        <table width="100" cellspacing="15">
            <tr>
                <td colspan="2" align="center" valign="middle">&nbsp;<h3>Please Login</h3></td>
            </tr>
            <tr>
                <td align="right">PantherID:</td>
                <td><input name="pantherID" type="text" id="pantherID"/></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input name="password" type="password" id="password"/></td>
            </tr>
        </table>
        <br/>
        <input type=submit value="Login">
        <br/>
        <br/>
    </form>
</div>
<div id="footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
