package main;

import java.io.InputStream;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	Boolean ok,oki;
	PApplet app;
	int interfaces;

	PImage larry[];
	int limite;

	int ly;
	float vel;

	public Logica(PApplet app) {

		this.app = app;
		ly = 30;
		vel = 1;

		ok = false;
		oki = false;

	}

	public void interfaces() {

		switch (interfaces) {
		case 0:
			larry();
		}

	}

	public void larry() {

		if (app.frameCount % 2 == 0) {
			limite++;
		}

		if (limite > 7)
			limite = 0;

		larry = new PImage[8];
		for (int i = 0; i < larry.length; i++) {

			larry[i] = app.loadImage("data/lar" + (i + 1) + ".png");
		}

		app.image(larry[limite], 1000, ly);

	}

	public void moverAbajo() {

		ly += 20;
	}


	public void moverArriba() {

		ly -= 20;

	}
	

	public void mo() {
		ly += 30;

	}

	public void n() {

		app.fill(200, 0, 0);
		app.ellipse(600, 350, 100, 100);

	}

}