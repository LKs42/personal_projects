package com.game.src.main;

import java.awt.Graphics;
import java.util.Random;

public class BulletE implements Entity{
	private double x;
	private double y;
	private int sy;
	private int sx;
	Random random=new Random();
	
	Animation anim;
	
	private Texture tex;
	
	public BulletE(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		sy = (random.nextInt(10));
		if (sy == 0)
			sy++;
		sx = (random.nextInt(20)-10);
		anim = new Animation(5,tex.missileE[0],tex.missileE[1],tex.missileE[2]);
	}
	public double getY() {
		return y;
	}
	public void tick(){
		y += sy;
		x += sx;
		anim.runAnimation();
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
	
	public double getX() {
		return x;
	}

}
