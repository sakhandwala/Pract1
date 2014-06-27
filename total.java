package Pract1;

import java.io.IOException;
import java.util.*;

public class total {

		public static void main(String args[])
		{
			try {
				
		   // Check for Zipped File in that folder and extract its path 		
			checkZipped cz = new checkZipped();
			String path = cz.findFiles("C:/Users/skhandwala/Desktop/Input",".zip");
			
		   // Decompress the Zip File
			zip zip = new zip();
			String inputPath = zip.decompress(path, zip.OUTPUT_FILE);
			
		   // Validate File
			
		   blankLines bl = new blankLines();
		   String finalFile = bl.validate(inputPath);
			
		   System.out.println(finalFile);
		   
		   //Zip the File again 
			
		   	//ZipIt zi = new ZipIt();
		   	//zi.zipAgain(finalFile);
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
