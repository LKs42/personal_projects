package com.game.src.main;

import java.awt.Graphics;

public class Bullet implements Entity{
	private double x;
	private double y;
	
	Animation anim;
	
	private Texture tex;
	
	public Bullet(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		anim = new Animation(5,tex.missile[0],tex.missile[1],tex.missile[2],tex.missile[3]);
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}
	public void tick(){
		y -= 5;
		anim.runAnimation();
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	public double getX() {
		return x;
	}

}
