package Pract1;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.filechooser.FileNameExtensionFilter;

public class checkZipped {

	/*public static void main(String args[])
	{
		final String SOURCE_DIR = "C:/Users/skhandwala/Desktop/Input";
		
		final String FILE_EXTENSION = ".zip";
				
		findFiles(SOURCE_DIR, FILE_EXTENSION);
	}*/
	
	 String findFiles(String dir, String ext)
	{
		File file = new File(dir);
		
		String path = null;
		
		File[] fileList = file.listFiles(new myFilter(ext));
		
		if(fileList.length==0)
		{
			
			path = "No_Files";
		}
		
		else
			for(File f: fileList)
			{
				path = f.getAbsolutePath();
				
				return path;
			}
		return path;
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
	}
	
