<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>

	 <form method="post" action="UploadServlet" enctype="multipart/form-data" class="FileForm">
      	
    		<!-- <div id="formOptions"> -->
    		<div id="formOptions" Style="width:300px;">    		
      	
      		<input type="text" name="FullName" id="name" placeholder="Enter Name" maxlength="20"/><br>
			<input type="text" name="HomeAddress" id="address" placeholder="Enter Address" maxlength="20"/><br>
		
			<input type="file" name="File1" id="File1" class="File_options"/><br>
			</div>
			
			<a id="add_more_fields"><input type="button" value="Add More"></a>
     		<a  id="remove_fields"><input type="button" value="Remove Field"></a><br>
	
			<input type="Submit" name="Submit" value="Submit"/> 
	

    
  </form>
<script src="AddMore.js"></script>
</body>
</html>