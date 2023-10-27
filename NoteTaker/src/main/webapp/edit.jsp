<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_js_css.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Edit your note here</h1>

		<%
		int id = Integer.parseInt(request.getParameter("note_id"));
		Session s = FactoryProvider.getSessionFactory().openSession();
		Note note = s.get(Note.class, id);
		%>

		<form action="UpdateServlet" method="post">
		<input value="<%=note.getId()%>" name="noteId" type="hidden" />
			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title"
					value="<%=note.getTitle()%>">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" id="content" class="form-control"
					name="content" placeholder="Enter your notes here"
					style="height: 300px;" ><%=note.getContent()%>></textarea>
			</div>
			<div Class="container text-center">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</body>
</html>