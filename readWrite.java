package Pract1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class readWrite {
	
	public static void main(String args[])
	{
		readWrite rw = new readWrite();
		rw.readFile();
		
	}
	
	public void readFile()
	{
	     try{
	    	 String s=null;
	    	 
	    	 File file2 = new File("C:/Users/skhandwala/Desktop/Input/selfM.txt");
	    	 
	    	 file2.createNewFile();
	    	 
	    	 File file = new File("C:/Users/skhandwala/Desktop/Input/self.txt");
	    	 
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
	    	 
	    	 FileWriter fw = new FileWriter(file2,true);
	    	 BufferedWriter bw = new BufferedWriter(fw);
			
	    	 while((s=br.readLine())!=null)
	    	 {
	    		//System.out.println(s);
	    		bw.write(s);
	    		bw.newLine();
	    	 }
	    	 
	    	 System.out.println("All data successfully transferred");
	    	 
	    	 br.close();
	    	 bw.close();
	    	 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	     
	}

}
