package com.chirag;

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
    gsArgs[0] = "gswin64.exe";
    gsArgs[1] = "-sDEVICE=pdfwrite";
    gsArgs[2] = "-dCompatibilityLevel=1.4";
    gsArgs[3] = "-dPDFSETTINGS=/screen"; //13.4mb to 4.3mb  /screen = 72dpi
//    gsArgs[3] = "-dPDFSETTINGS=/printer"; 13.4mb to 10.2mb  /printer=150dpi
    gsArgs[4] = "-dQUIET";
    gsArgs[5] = "-dNOPAUSE";
    gsArgs[6] = "-dBATCH";  
    gsArgs[7] = "-sOutputFile=D:\\3.pdf";	//output File
    gsArgs[8] = "D:\\2.pdf";				//Input file
 
    // execute and exit interpreter
    
    
    //look for filesize
    
    
    
//    input >>>buffer >>convert>>upload
   
//    
//    >1<
//    
//    1024byte
    try {
 
        gs.initialize(gsArgs);
        gs.exit();
 
    } catch (GhostscriptException e) {
        System.out.println("ERROR: " + e.getMessage());
    }
    }
 
}