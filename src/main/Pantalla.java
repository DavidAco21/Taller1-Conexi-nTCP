package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Pantalla {
	
	PApplet app;
	PImage pantallaJuego;
	
	int interfaces;
	
	public Pantalla(PApplet app) {
		pantallaJuego= app.loadImage("escenarioV.png");
		
		this.app=app;
		
	}
	
	
	public void pantallas() {
		
		
		switch(interfaces) {
		case 0:
		app.image(pantallaJuego, 0, 0);
		
		
		
		
		}
		
		
	}

}
