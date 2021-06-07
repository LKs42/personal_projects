package com.game.src.main;

import java.awt.Graphics;

public class Ennemy implements Entity{
	private double speed = Math.random() * (10-1);
	private double x;
	private double y;
	private Texture tex ;
	
	Animation anim;
	
	public Ennemy(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		int k = (int)(Math.random() * (4-1) + 1);
		switch(k){
		case 1:
			anim = new Animation(5,tex.ennemy[0],tex.ennemy[1],tex.ennemy[2]);
		break;
		case 2:
			anim = new Animation(5,tex.ennemy2[0],tex.ennemy2[1],tex.ennemy2[2]);
		break;
		case 3:
			anim = new Animation(5,tex.ennemy3[0],tex.ennemy3[1],tex.ennemy3[2]);
		break;
		}
		
	}
	public void tick(){
		y += speed;
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
