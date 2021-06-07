package com.game.src.main;

import java.awt.Graphics;

public class Explosion implements Entity{
	private double x;
	private double y;
	private Texture tex ;
	private int frame = 0;
	
	Animation anim;
	
	public Explosion(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		anim = new Animation(5,tex.explosion[0],tex.explosion[1],tex.explosion[2],tex.explosion[3],tex.explosion[4],tex.explosion[5],tex.explosion[6],tex.explosion[7],tex.explosion[8],tex.explosion[9]);
	}
	public void tick(){
		frame++;
		anim.runAnimation();
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
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	
	
}
