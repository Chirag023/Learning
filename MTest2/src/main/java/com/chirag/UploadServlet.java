package com.chirag;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;






/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Upload Servlet");
		System.out.println(request);
		
		String realPath = "D:\\upTest\\";
		String name = null;
		String address = null;
		
		String[] Fname = new String[10];
		FileItem[] FItem = new FileItem[10];
		String[] ext = new String[10];
		
		System.out.println(realPath);
		boolean isValid = isValidPath(realPath);
		System.out.println(isValid);
		
		
		int num = 0;
		int count= 0;
		
		String msg = null;
		
		if (isValid==true)
		{
		//isMultipart to determine whether the HTTP request is multi-part
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(!isMultipart) {
			System.out.println("Not multipart/File not uploaded");
			
		}
		else {
			//FileItemFactory, interface for creating FileItem instances.
			FileItemFactory factory = new DiskFileItemFactory();
			
			/* ServletFileUpload, processing file uploads; handles multiple files per single HTML page,
			sent using multipart/mixed encoding. */
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			List items = null;
			
			try {
				items = upload.parseRequest(request);
				//printing items
				System.out.println("items= "+items);
				
			}//end of try
			
			catch (FileUploadException e){
				System.out.println("File Upload Exception="+e);
			}//end of catch
			
			//process uploaded items
			Iterator itr = items.iterator();
			
			//Start of WHile Loop
			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				
				/* isFormField, determines whether or not a FileItem instance represents a 
				simple form field 
				Start of IF*/
				if(item.isFormField()) {
					//User input
					String Name = item.getFieldName(); 
					String Value = item.getString();
					
					System.out.println("Name/Value=" +Name+"/"+Value);
					
					//Assigning the user inputs
					if((Name.equals("Name"))&&(Name!=null)){
						Name = Value;
						System.out.println("Name = "+Name);
						
					}
					if((Name.equals("Address"))&&(Name!=null)) {
						address = Value;
						System.out.println("Address= "+address);
					}
					
					//counting number of items
					count++;
				}//end of if loop
				
				//Start of else
				else {
					try {
						//Item name
						String itemName = item.getFieldName();
						System.out.println("Item Name= "+itemName);
						
						//Name of item being uploaded
						String IName = item.getName();
						
						int len = IName.length();
						
						System.out.println("Item="+ IName);
						
						ext[num] = FilenameUtils.getExtension(IName);
						
						//For File1
						if(itemName != null) {
							System.out.println();
							System.out.println("Number = "+num);
							
							Fname[num] = itemName+"."+ext[num];
							System.out.println("Name= "+Fname[num]);
							System.out.println("ext=" +ext[num]);
							
							
							//need to check this later
							FItem[num] = item;
							System.out.println("item="+item);
							
							num++;
						}//end of File
						
					}//end of try
					
					catch(Exception e){
						System.out.println(e.getMessage());
					}//end of catch 
					
				}//end of else
				
			}//end of while loop
			
		}//end of else[multipart]
		
		//need to put extension validation below here
		int i=0;
		for(int j=0; j<num && isValid==true; j++) {
			
			while(i<num && isValid==true){
				isValid = isPDF(ext[i]);
				System.out.println("While loop File["+i+"]/extension= " +ext[i]+"["+isValid+"]");
				i++;
			}

			if(isValid == true) {
		
				try {
					File dir = new File(realPath);
			
					if(!dir.exists()) {
						dir.mkdirs();
					}
			
			
					System.out.println();
					String filePath = realPath + Fname[j];
					System.out.println("Filepath= "+filePath);
					File savedFile = new File(filePath);
					FItem[j].write(savedFile);
					System.out.println("File uploaded!");
				
				}//end of try
				catch(Exception e) {
					System.out.println(e.getMessage());
				}//end of catch
			}//end of if
			else {
				msg = "Incorrect file type";
				//System.out.println("Incorrect file type");
			}
		}//end of for loop
		}
		else {
			msg = "no path avaiable";
		}
		
		//response.sendRedirect(request.getContextPath());
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/view/index.jsp?msg="+msg));
	}//end of doPost
	
	public boolean isPDF(String ext) {
		boolean isPdf= false;
		
		if(ext.equals("pdf")||ext.equals("PDF")) {
			isPdf = true;
			
		}
		
		return isPdf;
	}
	
	public static boolean isValidPath(String path) {
		boolean valid;
		try {
			Path check = Paths.get(path);
			valid = Files.exists(check);
			
			
		}
		catch(InvalidPathException|NullPointerException ex) {
			System.out.println(ex);
			return false;
		}
		return valid;
	}

}//end of UploadServlet