package edu.ung.phys2211;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author naharrison
 */
public class DiscreteRocket extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("edu.ung.phys2211.DiscreteRocket");
	}
	
	public float bgImgX;
	public PImage bgImg;
	
	public void settings() {
		size(1000, 600);
	}
	
	
	public void setup() {
		frameRate(30);
		bgImg = loadImage(BGImageType.values()[new Random().nextInt(BGImageType.values().length)].getImgName());
		bgImgX = width;
	}
	
	
	public void draw() {
		background(240);

		strokeWeight(3);
		stroke(0);
		fill(20, 200, 20);
		rect(width/2, height/2, 20, 20);
		
		bgImgX = bgImgX - 12;
		image(bgImg, bgImgX, height/4, 100, 100);
		
		if(bgImgX < 0) updateBGImg();
	}
	

	public void updateBGImg() {
		bgImgX = width;
		bgImg = loadImage(BGImageType.values()[new Random().nextInt(BGImageType.values().length)].getImgName());
	}
	
	
}
