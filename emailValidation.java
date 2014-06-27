package Pract1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailValidation {
	
	public static void main(String args[])
	{
		
		final Pattern pattern;
		Matcher matcher;
		
		int lines = 0;
		int errors = 0;
		
        File file = new File("C:/Users/skhandwala/Desktop/Input/email.txt");
        
        
		
		Scanner in = null;
		try {
			in = new Scanner(file, "UTF-8");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		final String EMAIL_VALIDATION_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		
		pattern = Pattern.compile(EMAIL_VALIDATION_PATTERN);
		
		String data = in.nextLine();
		
		while(in.hasNext())
		{
			lines++;
			matcher = pattern.matcher(data);
			if(!matcher.matches())
			{
				errors++;
			}
			
			data = in.nextLine();
			
			
		}
		
	in.close();
		
		System.out.println("There are "+ lines + " Email Addresses, out of which "+ errors + " have errors in them");
			
	}

}
