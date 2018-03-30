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

	
	public final float vThrow = 11;
	public final float emptyMass = 100;
	public final int nTotalBlocks = 22;
	public final float frameRate = 30;
	public final float pixelsPerMeter = 120;
	public final float blockMass = 12;
	
	public float bgImgX, vx, thrownBlockX;
	public int nThrown;
	public PImage throwImg, bgImg, errorImg;

	
	public void settings() {
		size(1000, 600);
	}
	
	
	public void setup() {
		frameRate(frameRate);
		throwImg = loadImage("figs/nh.jpg");
		bgImg = loadImage(BGImageType.values()[new Random().nextInt(BGImageType.values().length)].getImgName());
		errorImg = loadImage("figs/grumpySquidward.jpg");
		vx = (float) 0.5;
		thrownBlockX = -200;
		nThrown = 0;
		bgImgX = width;
	}
	
	
	public void draw() {
		background(250);

		// human + sled + blocks
		image(throwImg, width/2 - 25, height/2 + 70, 175, 175);
		stroke(0);
		fill(0);
		rect(width/2 - 25, height/2 + 245, 340, 15); // sled
		drawStackOfBlocks();
		rect(thrownBlockX*pixelsPerMeter, height/2 + 100, 17, 17);
		thrownBlockX += -(vThrow/frameRate); // meters
		
		// throw button
		stroke(20, 150, 20);
		fill(20, 150, 20);
		rect(width - 50, height - 50, 50, 50);

		// background image
		bgImgX = bgImgX - vx;
		image(bgImg, bgImgX, 0, 140, 140);
		if(bgImgX < - 100) updateBGImg();
		
		// text
		textSize(32);
		fill(0);
		text(String.format("v = %3.3f m/s", vx), 70, height - 150);
		text(String.format("m = %3.3f kg", emptyMass + (nTotalBlocks - nThrown)*blockMass), 70, height - 100);
		text(String.format("p = %3.3f kg*m/s", vx*(emptyMass + ((float)(nTotalBlocks - nThrown))*blockMass)), 70, height - 50);

		// error image
		if(nThrown > nTotalBlocks) image(errorImg, 0, 0, width, height);
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
			thrownBlockX = (width/2 - 30)/pixelsPerMeter; // meters
			
			float massBeforeThrow = emptyMass + (nTotalBlocks - nThrown + 1)*blockMass;
			float vAfterThrow = (float) (1.0/massBeforeThrow)*(massBeforeThrow*vx + blockMass*vThrow);
			vx = vAfterThrow;
		}
	}
	
	
}
