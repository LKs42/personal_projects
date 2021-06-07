package com.game.src.main;

import java.awt.Graphics;

public class Bonus implements Entity{
	private double x;
	private double y;
	private Texture tex;
	
	Animation anim;
	
	public Bonus(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		anim = new Animation(5,tex.bonus[0],tex.bonus[1],tex.bonus[2],tex.bonus[3],tex.bonus[4],tex.bonus[5],tex.bonus[6],tex.bonus[7]);
	}

	public void tick(){
		y += 2;
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
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	
	
}
