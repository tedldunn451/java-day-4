package com.cooksys;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
	
	public static void main(String[] args) {
		
//		try {
//			File file = new File("text.txt");
//			InputStream is = new FileInputStream(file);
//			byte[] text = new byte[is.available()];
//			is.read(text);
//			System.out.println(Arrays.toString(text));
//			
//			OutputStream os = new FileOutputStream("other.txt");
//			os.write(text);
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("The file text.txt does not exist!");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			Socket s = new Socket("localhost", 8080);
			
			File file = new File("text.txt");
			InputStream is = new FileInputStream(file);
			byte[] text = new byte[is.available()];
			is.read(text);
			System.out.println(Arrays.toString(text));
			
			OutputStream output = new DataOutputStream(s.getOutputStream());
			
			output.write(text.length);
			output.write(text);
			
			output.close();
			is.close();
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
