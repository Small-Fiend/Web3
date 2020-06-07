<%@ page import="Core.User" %>
<%response.addHeader("Cache-Control","no-cache");%>

<%
    final int TIMEOUT_SECONDS = 5;
    if ((boolean) request.getAttribute("checkEmpty")) {
        response.setHeader("Refresh", TIMEOUT_SECONDS + ";url=index.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../style.css" rel="stylesheet" type="text/css">
</head>
<body class="result_page">



<form id = "main_block" method = "POST" action="/result">
    <div id = "top_menu">
        <a href="index.jsp" id = back_link><</a>
        <h1 id = "text_top">Table about comments</h1>
        <input type="submit" class="button" style="vertical-align:middle" name = "button" value=Enter>
        <h3 id = "user_hello">Hello, <%= request.getAttribute("name")%></h3>

    </div>
    <table>
        <% if (!(boolean) request.getAttribute("checkEmpty")) {
            User user = (User) request.getAttribute("User");

            for (int i = 0; i < user.getLength(); i++){
        %>   <tr><th> <%= user.getBranch().get(i).getNameBranch() %></th></tr>
        <%
            for (int j = 0; j < user.getBranch().get(i).getLength(); j++){
        %> <tr><td>  <%=  user.getBranch().get(i).getCouch(j).getinitials() %> </td><td>  <%=  user.getBranch().get(i).getCouch(j).getSpecialization() %> </td><td>  <%=  user.getBranch().get(i).getCouch(j).getPhoneNumber() %> </td><td>  <%=  user.getBranch().get(i).getCouch(j).getBirthday() %> </td></tr>
        <%
            }
        %>
        <%   }
        } %>
        <tr>
    </table>
    <a id = "download_link" href="/result.xml">download</a>
</form>
</body>
</html>