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
	
	public float bgImgX, vx, vThrow, emptyMass, blockMass;
	public int frameRate, nTotalBlocks, nThrown;
	public PImage bgImg, throwImg;
	
	public void settings() {
		size(1000, 600);
	}
	
	
	public void setup() {
		frameRate = 20;
		frameRate(frameRate);
		background(250);
		vx = 9;
		vThrow = 23;
		emptyMass = 100;
		blockMass = 12;
		nTotalBlocks = 20;
		nThrown = 0;
		throwImg = loadImage("figs/nh.jpg");
		bgImg = loadImage(BGImageType.values()[new Random().nextInt(BGImageType.values().length)].getImgName());
		bgImgX = width;
	}
	
	
	public void draw() {
		// human + sled + block stack
		image(throwImg, width/2 - 25, height/2 + 70, 175, 175);
		stroke(0);
		fill(0);
		rect(width/2 - 25, height/2 + 245, 340, 15);
		drawStackOfBlocks();
		
		// throw button
		stroke(20, 150, 20);
		fill(20, 150, 20);
		rect(width - 50, height - 50, 50, 50);

		bgImgX = bgImgX - vx;
		image(bgImg, bgImgX, height/4, 100, 100);
		if(bgImgX < - 100) updateBGImg();
	}
	

	public void updateBGImg() {
		bgImgX = width;
		bgImg = loadImage(BGImageType.values()[new Random().nextInt(BGImageType.values().length)].getImgName());
	}
	
	
	public void drawStackOfBlocks() {
		for(int k = 0; k < nTotalBlocks - nThrown; k++) {
			rect(width/2 + 175, height/2 + 245 - 20 - k*20, 17, 17);
		}
	}
	
	
	public void mouseClicked() {
		if(mouseX > width - 50 && mouseY > height - 50) {
			nThrown++;
		}
	}
	
	
}
