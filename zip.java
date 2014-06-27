package Pract1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class zip {
	
	 final static  String OUTPUT_FILE = "C:/Users/skhandwala/Desktop/Input";

	/*	String filename;
		
		 final static  String INPUT_FOLDER = "C:/Users/skhandwala/Desktop/Input/self.zip";
		
		
		public static void main(String args[])
		{
			zip unzip = new zip();
			
			try {
				unzip.decompress(INPUT_FOLDER, OUTPUT_FILE);
				
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
		} */
		
		
		public String decompress(String zipFile, String outputFolder) throws IOException
			{
			    String outputPath= "";
			    byte[] buffer = new byte[1024];
			
			  ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			  
			  ZipEntry ze = zis.getNextEntry();
			  
			  while(ze!=null){
				  
		    	   String fileName = ze.getName();
		           File newFile = new File(outputFolder + File.separator + fileName);
		           
		           outputPath = newFile.getAbsolutePath();
		 
		           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
		 
		            //create all non exists folders
		            //else you will hit FileNotFoundException for compressed folder
		            new File(newFile.getParent()).mkdirs();
		 
		            FileOutputStream fos = new FileOutputStream(newFile);             
		 
		            int len;
		            while ((len = zis.read(buffer)) > 0) {
		       		fos.write(buffer, 0, len);
		            }
		 
		            fos.close();   
		            ze = zis.getNextEntry();
		    	}
		 
			  System.out.println("File Unzipped");
			  zis.closeEntry();
			  zis.close();
			  
			  
			  return outputPath;
			  
			}
			
		}
		

