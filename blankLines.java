package Pract1;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class blankLines {
	
        
	  public String validate(String inputPath) throws IOException
	  {
		
		File file = new File(inputPath);
		
		String fileName = file.getName();
		
		fileName = "C:/Users/skhandwala/Desktop/New/"+ "M"+ fileName; 
		
		File cleanedFile = new File(fileName);
		
		cleanedFile.createNewFile();
		
		Scanner in = new Scanner(file);
		PrintStream ps = new PrintStream(cleanedFile);
		
		while(in.hasNextLine())
		{
			String str = in.nextLine();
			str = str.trim();
			if(str.length()>0)
			{
				ps.println(str);
			}
		}
		
		System.out.println("Success");
		
		return cleanedFile.getAbsolutePath();

}
}
