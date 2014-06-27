package Pract1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

import de.flexiprovider.core.FlexiCoreProvider;

public class encryption2 {
	
	public static void main(String args[])
	{
	
    Security.addProvider(new FlexiCoreProvider());
	
	try {
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
	    Cipher cipher = Cipher.getInstance("RSA");
		 
		kpg.initialize(1024);
		KeyPair keyPair = kpg.generateKeyPair();
		PrivateKey privKey = keyPair.getPrivate();
		PublicKey pubKey = keyPair.getPublic();
		
	
	cipher.init(Cipher.ENCRYPT_MODE, pubKey);
	
	File file = new File("C:/Users/skhandwala/Desktop/Input/encryptedFile.txt");
	File file2 = new File("C:/Users/skhandwala/Desktop/Input/decryptedFile.txt");
	file2.createNewFile();
	file.createNewFile();
	
	
	File file3 = new File("C:/Users/skhandwala/Desktop/Input/self.txt");
	
	FileInputStream fis = new FileInputStream(file3);
	FileOutputStream fos = new FileOutputStream(file);
	CipherOutputStream cos = new CipherOutputStream(fos, cipher);
	
	
	byte[] block = new byte[32];
	int i;
	
	while((i=fis.read(block))!=-1)
	{
		System.out.println(i);
		
		cos.write(block,0,i);
	}
	
	cos.close();
	
	
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	
	} catch (NoSuchPaddingException e) {
		e.printStackTrace();
	} catch (InvalidKeyException e) {
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
}

