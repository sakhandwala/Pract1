package Pract1;
import com.jcraft.jsch.*;


public class scpDemo {
	
	public scpDemo()
	{
		super();
	}
	
	
	public static void main(String args[])
	{
		try
		{
			JSch jsch = new JSch();
			
			String host = "sakh89@login.ccs.neu.edu";
			String pwd = "Kami$1";
			String command = "sh /home/sakh89/Desktop/input/main.sh";
			
			System.out.println("Begin");
			
			String user = host.substring(0, host.indexOf('@'));
			host = host.substring(host.indexOf('@')+1);
			Session sessionJSH = jsch.getSession(user,host,22);
			sessionJSH.setPassword(pwd);
			java.util.Hashtable configJSH = new java.util.Hashtable();
			configJSH.put("StrictHostKeyChecking", "no");
			sessionJSH.setConfig(configJSH);
			sessionJSH.connect();
			
			System.out.println("Progressing");
			
			Channel channel = sessionJSH.openChannel("exec");
			((ChannelExec)channel).setCommand(command);
			
			channel.connect();
			channel.disconnect();
			sessionJSH.disconnect();
			
			System.out.println("Done");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}