<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>

<%
String msg = request.getParameter("msg");
System.out.println(msg);

if (msg == null){
 msg="";

}
%>

<table>
<tr>
<td><%=msg %></td>


</tr>
</table>

	 <form method="post" action="<%=request.getContextPath() %>/UploadServlet" enctype="multipart/form-data" class="FileForm">
      	
    		<div id="formOptions">
    		<!-- <div id="formOptions" Style="width:300px;">  -->   		
      	
      		<input type="text" name="FullName" id="name" placeholder="Enter Name" maxlength="20"/><br>
			<input type="text" name="HomeAddress" id="address" placeholder="Enter Address" maxlength="20"/><br>
		
			<input type="file" name="File" id="file_check" class="File_options"/><br>
			</div>
			
			<a id="add_more_fields"><input type="button" value="Add More"></a>
     		<a  id="remove_fields"><input type="button" value="Remove Field"></a><br>
	
			<input type="Submit" name="Submit" value="Submit"/> 
	

    
  </form>
 <script type="text/javascript" src="AddMore.js"></script>
  
  <!-- 
<script src="AddMore.js"></script> -->
</body>
</html>