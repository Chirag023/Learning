package com.compress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.ghost4j.Ghostscript;
import org.ghost4j.GhostscriptException;

/**
 * Example showing how to convert a Postscript file to PDF.
 * 
 * @author Gilles Grousset (gi.grousset@gmail.com)
 */
public class PDFCompress {

	public static void main(String[] args) {

		// get Ghostscript instance
		Ghostscript gs = Ghostscript.getInstance();

		// prepare Ghostscript interpreter parameters
		// refer to Ghostscript documentation for parameter usage
		
		String[] gsArgs = new String[9];
		gsArgs[0] = "gswin64c";
		gsArgs[1] = "-sDEVICE=pdfwrite";
		gsArgs[2] = "-dCompatibilityLevel=1.4";
		gsArgs[3] = "-dPDFSETTINGS=/screen"; //13.4mb to 4.3mb  /screen = 72dpi
		//    gsArgs[3] = "-dPDFSETTINGS=/printer"; 13.4mb to 10.2mb  /printer=150dpi
		gsArgs[4] = "-dQUIET";
		gsArgs[5] = "-dNOPAUSE";
		gsArgs[6] = "-dBATCH";  
		
		String output = "D:\\1.pdf";				//output File	
		gsArgs[7] = "-sOutputFile=" +output;
		
		String input = "D:\\test.pdf";
		
		File in = new File(input);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(in));
			bw.close();
			System.out.println("Buffer: " + bw);
			
			BufferedReader br = new BufferedReader(new FileReader(in));
			System.out.println(br);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		gsArgs[8] = input;				//Input file

		
/*		String[] gsArgs = new String[20];
		gsArgs[0] = "gswin64.exe";
		gsArgs[1] = "-q";
		gsArgs[2] = "-dNOPAUSE";
		gsArgs[3] = "-dBATCH";  
		gsArgs[4] = "-dQUIET";
		gsArgs[5] =	"-dOverPrint=/simulate";
		gsArgs[6] = "-sDEVICE=pdfwrite";
		gsArgs[7] = "-dPDFSETTINGS=/screen";
		gsArgs[8] = "-dEmbedAllFonts=true";
		gsArgs[9] = "-dSubsetFonts=true";
		gsArgs[10] = "-dAutoRotatePages=/None";
		gsArgs[11] = "-dColorImageDownsampleType=/Bicubic";
		gsArgs[12] = "-dColorImageResolution=150";
		gsArgs[13] = "-dGrayImageDownsampleType=/Bicubic";
		gsArgs[14] = "-dGrayImageResolution=150";
		gsArgs[15] = "-dMonoImageDownsampleType=/Bicubic"; 
		gsArgs[16] = "-dMonoImageResolution=150";
		gsArgs[17] = "-dCompatibilityLevel=1.4";
		
		String output = "D:\\10.pdf";	//output File	
		gsArgs[18] = "-sOutputFile=" +output;
		
		String input = "D:\\test.pdf";
		gsArgs[19] = input;				//Input file
*/

		//look for filesize

/*		String[] gsArgs = new String[4];
		gsArgs[0] = "gswin64.exe";
		gsArgs[1] = "-sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/screen -dQUIET -dNOPAUSE -dBATCH";  
		
		String output = "D:\\1.pdf";				//output File	
		gsArgs[2] = "-sOutputFile=" +output;
		
		String input = "D:\\test.pdf";
		gsArgs[3] = input;				//Input file
*/
		//    input >>>buffer >>convert>>upload

		//    
		//    >1<
		//    
		//    1024byte
		try {

			gs.initialize(gsArgs);
			gs.exit();
//			RenameFile(gsArgs[8], output);
			System.out.println("Compressed");

		} catch (GhostscriptException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	public static boolean RenameFile(String dest,String target) {
		boolean check = false;

		File oldName = new File(dest);
		System.out.println("Old: "+oldName);
		
		File newName = new File(target);
		System.out.println("New: "+newName);

		if(oldName.exists()) {
			check = oldName.delete();
			System.out.println("Old File Deleted");	
			
			check = newName.renameTo(oldName);
			System.out.println("File Renamed");
						
		}
		else {
			System.out.println("Rename error");
		}
		return check;
	}

}