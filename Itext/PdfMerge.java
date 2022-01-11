package iTextSample;

import java.util.Scanner;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;

public class PdfMerge {
	public static void main(String[] args) throws Exception{
//		String path = "D:/upTest/";
		Scanner sc = new Scanner(System.in);
		
		//Name of First File
//		System.out.println("First document:");
//		String First = sc.nextLine();

		//Name of Second File
//		System.out.println("Second document:");
//		String Second = sc.nextLine();
		
		//Path of First and Second file
		String FirstFile = "D:/upTest/test.pdf";
		String SecondFile = "D:/upTest/sample.pdf";
		System.out.println("FirstFile= "+FirstFile+"/SecondFile"+SecondFile);
		
		//Destination folder for the end result
		String dest = "D:/upTest/merge.pdf";
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));//Throws Exception
		
		PdfMerger merger = new PdfMerger(pdf);
		
		//Adding from first PDF
		PdfDocument FirstSource = new PdfDocument(new PdfReader(FirstFile));
		merger.merge(FirstSource, 1, FirstSource.getNumberOfPages());
		System.out.println("FirstSource= "+FirstSource);

		//Adding from 2nd PDF
		PdfDocument SecondSource = new PdfDocument(new PdfReader(SecondFile));
		merger.merge(SecondSource, 1, SecondSource.getNumberOfPages());
		System.out.println("SecondSource= "+SecondSource);
		
		FirstSource.close();
		SecondSource.close();
		pdf.close();
		
	}
}
