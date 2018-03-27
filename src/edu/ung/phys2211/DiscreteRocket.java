package edu.ung.phys2211;

import processing.core.PApplet;

/**
 * @author naharrison
 */
public class DiscreteRocket extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("edu.ung.phys2211.DiscreteRocket");
	}
	
	public float circleX;
	
	public void settings() {
		size(1000, 600);
	}
	
	
	public void setup() {
		frameRate(30);
		circleX = width;
	}
	
	
	public void draw() {
		background(240);
		
		strokeWeight(3);
		stroke(0);
		fill(20, 200, 20);
		rect(width/2, height/2, 20, 20);
		
		stroke(150);
		fill(20, 20, 200);
		circleX = circleX - 2;
		ellipse(circleX, height/4, 40, 40);
	}
	
	
}
