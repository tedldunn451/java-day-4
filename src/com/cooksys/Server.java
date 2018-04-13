package com.cooksys;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main (String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8080);
			Socket client = ss.accept();
			
			InputStream input = new DataInputStream(client.getInputStream());
			byte[] file = new byte[input.read()];
			input.read(file);
			
			OutputStream fos = new FileOutputStream("anotherFile.txt");
			fos.write(file);
			
			fos.close();
			input.close();
			client.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
