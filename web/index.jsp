<%response.addHeader("Cache-Control","no-cache");%>
<% if (request.getAttribute("checkError") == null){ request.setAttribute("checkError", true);}%>
<!DOCTYPE html>
<html lang="en" style="background: rgba(186, 186, 236, 0.41)">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div>
    <div id = "text_main_page">
        <h2>Log in</h2>
    </div>


    <form id = "area_enter" method="post" action="/index">
        <div>
            <label class ="input_label" >Login</label><br />
            <% if ((boolean) request.getAttribute("checkError")){%>
            <input class = "input" type = "text" name = "login"/><br/>
            <% } else { %>
            <input class = "input_error" type = "text" name = "login" required placeholder="This field is required" /><br/>
            <% } %>
            <label class ="input_label">Password</label><br />
            <% if ((boolean) request.getAttribute("checkError")){%>
            <input class = "input" type = "password" name = "password"/><br/>
            <% } else { %>
            <input class = "input_error" type = "password" name = "password" required placeholder="This field is required" /><br/>
            <% } %>

            <input type="submit" class="button_index" style="vertical-align:middle" name = "button" value=Enter>
        </div>
    </form>

</div>
</body>
</html>