package com.game.src.main;

import java.awt.Graphics;

public class Bullet3 implements Entity{
	private double x;
	private double y;
	private double cos;
	private double sin;
	
	public double getCos() {
		return cos;
	}
	public void setCos(double cos) {
		this.cos = cos;
	}
	public double getSin() {
		return sin;
	}
	public void setSin(double sin) {
		this.sin = sin;
	}
	Animation anim;
	
	private Texture tex;
	
	public Bullet3(double x, double y, Texture tex, double cos, double sin){
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		this.cos = cos;
		this.sin = sin;
		
		anim = new Animation(5,tex.missile3[0],tex.missile3[1],tex.missile3[2]);
	}
	public double getY() {
		return y;
	}
	public void tick(){
		y -= sin * 5;
		x += cos * 5 ;
		anim.runAnimation();
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void invertX(){
		this.cos = -cos;
	}
	public void invertY(){
		this.sin = -sin;
	}

}
