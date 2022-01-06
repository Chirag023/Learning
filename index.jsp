<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	 <form method="post" action="UploadServlet" enctype="multipart/form-data" class="FileForm">
      	<div class="wrapper">
    		<div id="survey_options">
      	
      		<input type="text" name="FullName" id="name" placeholder="Enter Name" maxlength="20"/><br>
			<input type="text" name="HomeAddress" id="address" placeholder="Enter Address" maxlength="20"/><br>
		
			<input type="file" name="File1" id="File1" class="File_options"/><br>
			</div>
			<div class="controls">
				<a id="add_more_fields"><input type="button" value="Add More"></a>
     			<a  id="remove_fields"><input type="button" value="Remove Field"></a><br>
			</div>
			<input type="Submit" name="Submit" value="Submit"/> 
	
    </div>
    
  </form>
<script src="Script.js"></script>
</body>
</html>