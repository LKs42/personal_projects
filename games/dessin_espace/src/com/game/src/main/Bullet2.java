package com.game.src.main;

import java.awt.Graphics;

public class Bullet2 implements Entity{
	private double x;
	private double y;
	
	Animation anim;
	

	private Texture tex;
	
	public Bullet2(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		anim = new Animation(5,tex.missile2[0],tex.missile2[1],tex.missile2[2]);
	}
	public double getY() {
		return y;
	}
	public void tick(){
		y -= 10;
		anim.runAnimation();
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	public double getX() {
		return x;
	}

}
