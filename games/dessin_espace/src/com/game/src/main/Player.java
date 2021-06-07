package com.game.src.main;

import java.awt.Graphics;

public class Player {
	
	private double x;
	private double y;
	
	private double velX = 0;
	private double velY = 0;
	private Texture tex;
	
	private int pv = 100;
	
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	Animation anim;
	
	public Player(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		anim = new Animation(5,tex.player[0], tex.player[1], tex.player[2], tex.player[3], tex.player[4]);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		if(x <= 0){
			x = 0;
		}
		if(x >= 640 - 16 ){
			x = 640 - 16 ;
		}
		if(y <= 0){
			y = 0;
		}
		if(y >= 480 - 32){
			y = 480 - 32;
		}
		
		if(pv <= 0)
		{
			// il meurt
		}
		
		anim.runAnimation();
		
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void render(Graphics g){
anim.drawAnimation(g, x, y, 0);
	}

}
