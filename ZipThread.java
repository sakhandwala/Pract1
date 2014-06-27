package Pract1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import Pract1.checkZipped.myFilter;

public class ZipThread {
	
	public static void main(String args[])
	{
		while (true)
		{
		ZipThread zt = new ZipThread();
		ArrayList<String> ll = zt.findFiles("C:/Users/skhandwala/Desktop/Input",".zip");
		
		// for(int i=0;i<s.length;i++)
			System.out.println(ll);
		
		try {
		ArrayList<String> ff = zt.decompress(ll, "C:/Users/skhandwala/Desktop/New");
		
		System.out.println(ff);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		
	}
	
	 ArrayList<String> findFiles(String dir, String ext)
		{
			File file = new File(dir);
			
			//String[] path = null;
			
			ArrayList<String> as = new ArrayList<String>();
			
			//int i=0;
			
			File[] fileList = file.listFiles(new myFilter(ext));
			
			/*if(fileList.length==0)
			{	
				path = "No_Files";
			}*/
			
				for(File f: fileList)
				{
					as.add(f.getAbsolutePath());
					//path[i] = f.getAbsolutePath();
				//	i++;
				
				}
				
				return as;
			// return path;
		}
			
			static class myFilter implements FilenameFilter
			{
				String ext;
				
				myFilter(String ext)
				{
					this.ext= ext.toLowerCase();
				}

				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(ext);
				}
			}
			
			
			public ArrayList<String> decompress(ArrayList<String> zipFile, String outputFolder) throws IOException
			{
			    //String[] outputPath= null;
				ArrayList<String> al = new ArrayList<String>();
				 
			    byte[] buffer = new byte[1024];
			
			    
			   for(int i=0;i<zipFile.size();i++)
			   {
			    
				   String temp = zipFile.get(i);
				   
			       ZipInputStream zis = new ZipInputStream(new FileInputStream(temp));
			  
			       ZipEntry ze = zis.getNextEntry();
			  
			   while(ze!=null){
				  
		    	   String fileName = ze.getName();
		           File newFile = new File(outputFolder + File.separator + fileName);
		           
		           
		           
		           al.add(newFile.getAbsolutePath());
		 
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
			  
			}
			   
			  for(int i=0;i<zipFile.size();i++)
			  {
				  File file = new File(zipFile.get(i));
				  file.delete();
			  }
			   
			   
			   return al;
			//return outputPath;
}
}
