<%@ page import="java.util.*" %>
<%!											<!-- Check point 1. -->
	String enquote(String text){
		if(text.length() > 0)
			return "'" + text + "'";
		return text;
	}
%>
<%
	String name = request.getParameter("name");						<!-- Check point 2. -->
	if(name == null) name = "";
%>
<html>
	<head>
		<title>Welcome - BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Visitor <%=enquote(name)%></h1>				<!-- Check point 3. -->
		<b>Time on server: </b><%=new Date()%>
	</body>
</html>

<!-- ************************************************************************************************** -->

<!-- Comments about this programme :-

NOTE :-	Check "JspTagList.docx" for understand the use of JSP tags.

JSP tag for -> Seperate java code from HTML

POINTS :-
	1. Here we are defining the method because this is a Declaration(Declarative)  Tag.
		This tag is used for declare gloval variable, we can define method body  etc...

	2. This sciptlet tag which allowed us to use -
		Language-Construct (if, while, switch etc...)
		We can call user define method. (non printable method only)

	3. Here we are calling user-defined method because This is a expression tag which allowed us to-
		call userdefine method. It is used for print something on screen.
-->