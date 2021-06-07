package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Boss implements Entity{
	private double speed = 0;
	private double x;
	private double y;
	private Texture tex ;
	private int vie = 100;
	private boolean p1 = false;
	private boolean p2 = false;
	private boolean sp2 = false;
	Random random=new Random();
	
	
	Animation anim;
	
	public Boss(double x, double y, Texture tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		anim = new Animation(5,tex.boss[0],tex.boss[1],tex.boss[2]);	
	}
	public void tick(){
	//	y += Math.random() * (10) + 1;
		//x += Math.random() * (10) + 1;
		anim.runAnimation();
		phase1();
		phase2();
		collision();
	}
	public void phase1(){
		if (!p1)
		{
			if (!sp2)
			{
				y++;
				if (y >= (Game.HEIGHT*Game.SCALE)/4)
				{
					sp2 = true;
				}
			}
			if(sp2)
			{
				x++;
				if(x >=(Game.WIDTH*Game.SCALE)/2)
				{
					p1 = true;
				}
			}
			
		}
	}
	
	public boolean phase2(){
		int r = 0;
		if (p1)
		{
			r = (random.nextInt(100));
			if (r < 55 && r > 50)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean isP1() {
		return p1;
	}
	public void setP1(boolean p1) {
		this.p1 = p1;
	}
	public void collision()
	{
		if(x > Game.WIDTH * Game.SCALE  +16)
		{
			x = Math.random() * (Game.WIDTH * Game.SCALE);
			y = Math.random() * ((Game.HEIGHT * Game.SCALE) / 2);
		}
		else if (y > Game.HEIGHT * Game.SCALE +16)
		{
			x = Math.random() * (Game.WIDTH * Game.SCALE);
			y = Math.random() * ((Game.HEIGHT * Game.SCALE) / 2);
		}
		else if (y < 0)
		{
			x = Math.random() * ((Game.HEIGHT * Game.SCALE));
			y = Math.random() * ((Game.HEIGHT * Game.SCALE) / 2);
		}
		else if (x < 0)
		{
			x = Math.random() * (Game.WIDTH * Game.SCALE);
			y = Math.random() * ((Game.HEIGHT * Game.SCALE) / 2);
		}
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
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
