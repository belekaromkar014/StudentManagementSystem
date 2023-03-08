<h1> I am test JSP page </h1>

<%
    out.println(request.getAttribute("data"));
%>

<br>

Welcome to ${data}