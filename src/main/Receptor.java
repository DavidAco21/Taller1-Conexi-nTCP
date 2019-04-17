package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import processing.core.PApplet;

public class Receptor extends Observable implements Runnable {
	
	private InputStream is;

	PApplet app;
	String recibido;
	Logica log;
	
	
	public Receptor(InputStream is) {
		this.is=is;
		log = new Logica(app);

		
	}
	
	
	public void run() {
		DataInputStream dis = new DataInputStream(is);
		
		
		while(true) {
			
			try {
			 recibido = dis.readUTF();
				System.out.println(recibido);
				
				if(recibido.contains("down")) {
					  log.ok=true;
					 
					}
			
			
					
				//}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}
	
	
	
	

}
