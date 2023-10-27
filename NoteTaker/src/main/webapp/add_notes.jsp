<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="all_js_css.jsp"%>
<title>Note Taker</title>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please fill your notes details</h1>
		<br>

		<!--This is add form  -->

		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input
					name="title"
					type="text" 
					class="form-control"
					 id="title"
					aria-describedby="emailHelp" 
					placeholder="Enter title"> 
			</div>
			<div class="form-group">
				<label for="content">Note Content</label> 
				<textarea 
				name="content"
				id ="content" 
				class="form-control"
				name="content"
				 placeholder="Enter your notes here" 
				 style="height: 300px;" 
				required></textarea>
			</div>
			<div Class="container text-center">
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>

</body>
</html>