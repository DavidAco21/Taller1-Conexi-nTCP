package main;

import java.io.DataInputStream;
import java.io.IOException;import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Main extends PApplet implements Observer{
	
	private ArrayList<Socket> sockets;
	private Logica log ;
	private Pantalla pan;
	private DataInputStream entrada;

	public static void main(String[] args) {
		
		PApplet.main("main.Main");
	}
	
	
	public void setup() {
		
		log = new Logica(this);
		pan = new Pantalla(this);
		sockets =  new ArrayList<>();
		new Thread(()->{
			
			
			try {
				ServerSocket server = new ServerSocket(5000);
				while(true) {
					
					
			System.out.println(log.ok);
			System.out.println("esperando cliente...");
			 Socket socket = server.accept();
			 sockets.add(socket);
			 System.out.println("clientes: "+ sockets.size());
			 System.out.println(log.ok);
			 
			// Receptor receptor = new Receptor(socket.getInputStream());
			 //receptor.addObserver(this);
			 //new Thread(receptor).start();
			 
			 entrada= new DataInputStream(socket.getInputStream());
			 
			 while(true) {
					
					try {
					 String recibido = entrada.readUTF();
						System.out.println(recibido);
						
						if(recibido.contains("down")) {
							  log.ok=true;
							 
							}
						
						
						if(recibido.contains("up")) {
							  log.oki=true;
							 
							}
						
					
							
						//}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
			 
			 
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//172.30.166.245
		}).start();
		
		
		
		
	}

	
	public void settings() {
		size(1200,700);
		
	}
	
	public void draw() {
	
			 		
		pan.pantallas();
		
		if(log.ok==true && log.ly<500) {
		log.moverAbajo();
		log.ok=false;
		}
		
		if(log.oki==true && log.ly>30) {
			log.moverArriba();
			log.oki=false;
			}
		
		log.interfaces();
		
	
	
		
			
	}


	@Override
	public void update(Observable o, Object arg) {
		
		
	}
}
