package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {
private LinkedList<Bullet> b = new LinkedList<Bullet>();
private LinkedList<Ennemy> e = new LinkedList<Ennemy>();
private LinkedList<Explosion> ex = new LinkedList<Explosion>();
private LinkedList<Bullet2> b2 = new LinkedList<Bullet2>();
private LinkedList<Bullet3> b3 = new LinkedList<Bullet3>();
private LinkedList<Bonus> bo = new LinkedList<Bonus>();
private LinkedList<BulletE> be = new LinkedList<BulletE>();
private LinkedList<Boss> bos = new LinkedList<Boss>();

private int RandomTime;
private int enemykilled = 0;

Bullet TempBullet;
Ennemy TempEnnemy;
Explosion TempExplosion;
Bullet2 TempBullet2;
Bullet3 TempBullet3;
BulletE TempBulletE;
Bonus TempBonus;
Boss TempBoss;

Game game;
Texture tex;

double ennemycount = 0;
public static int cptBullet2 = 0;

public Controller(Game game, Texture tex)
{
	this.game = game;
	this.tex = tex;
	for (int i = 0; i < Math.random()*(20-1); i++){
	this.addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
	}

	this.addBonus(new Bonus(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
	//this.addBoss(new Boss(100, 0, tex));
}

public void tick(){
	
	if (enemykilled == 10 || enemykilled == 50 )
	{
		this.addBoss(new Boss(0, 0, tex));
		enemykilled++;
	}
	/*

	if (RandomTime > 4900 && RandomTime < 5000)
	{
		this.addBonus(new Bonus(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
	}
	else
	{
		RandomTime = ((int) (Math.random() * (10000-1)+1));
	}
	*/
	
	for(int i = 0; i < b.size(); i++){
		TempBullet = b.get(i);
		System.out.println(TempBullet.getY());
		if(TempBullet.getY() < 0)	
			removeBullet(TempBullet);
		
		TempBullet.tick();	
		for(int j = 0; j < e.size(); j ++)
		{
			if (TempBullet.getY() < e.get(j).getY())
			{
				if(TempBullet.getX() > (e.get(j).getX() - 16) && TempBullet.getX() < (e.get(j).getX())+16)
				{		
					this.addExplosion(new Explosion(e.get(j).getX(),e.get(j).getY(),tex));
					removeEnnemy(e.get(j));
				if (ennemycount == 0)
				{
					for(int k = 0; k < Math.random() * (5-1); k++)
					{
					addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
					}
				}
				}
			}
		}
		for(int l = 0; l < bos.size(); l ++)
		{
			if (TempBullet.getY() < bos.get(l).getY() + 32 && TempBullet.getY() > bos.get(l).getY() - 32)
			{
				if(TempBullet.getX() > (bos.get(l).getX() - 32) && TempBullet.getX() < (bos.get(l).getX())+32)
				{		
					this.addExplosion(new Explosion(bos.get(l).getX(),bos.get(l).getY(),tex));
					damagetaken(bos.get(l), 2);
				if (ennemycount == 0)
				{
					for(int k = 0; k < Math.random() * (5-1); k++)
					{
					//addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
					}
				}
				}
			}
		}
	}
	for(int i = 0; i < b2.size(); i++){
		TempBullet2 = b2.get(i);
		
		if(TempBullet2.getY() < 0)
			removeBullet2(TempBullet2);
		
		TempBullet2.tick();
		for(int j = 0; j < e.size(); j ++)
		{
			if (TempBullet2.getY() < e.get(j).getY())
			{
				if(TempBullet2.getX() + 50 > (e.get(j).getX() - 16) && TempBullet2.getX() - 50 < (e.get(j).getX())+16)
				{		
					this.addExplosion(new Explosion(e.get(j).getX(),e.get(j).getY(),tex));
					removeEnnemy(e.get(j));
				if (ennemycount == 0)
				{
					for(int k = 0; k < Math.random() * (5-1); k++)
					{
					addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
					}
				}
				}
			}
			

			for(int l = 0; l < bos.size(); l ++)
			{
				if (TempBullet2.getY() < bos.get(l).getY() + 32 && TempBullet2.getY() > bos.get(l).getY() - 32 )
				{
					if(TempBullet2.getX() > (bos.get(l).getX() - 32) && TempBullet2.getX() < (bos.get(l).getX())+32)
					{		
						this.addExplosion(new Explosion(bos.get(l).getX() ,bos.get(l).getY(),tex));
						this.damagetaken(bos.get(l), 4);
					if (ennemycount == 0)
					{
						for(int k = 0; k < Math.random() * (5-1); k++)
						{
						//addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
						}
					}
					}
				}
			}
			
		}
	}

	for(int i = 0; i < be.size(); i++){
		TempBulletE = be.get(i);

		if(TempBulletE.getY() < 0)
			removeBulletE(TempBulletE);
		else if(TempBulletE.getY() > (Game.HEIGHT * Game.SCALE))
			removeBulletE(TempBulletE);
		TempBulletE.tick();
		
	}
	for(int i = 0; i < b3.size(); i++){
		TempBullet3 = b3.get(i);

		if(TempBullet3.getY() <= 0){
			TempBullet3.invertY();
			//System.out.println("bullet3 deleted");
			//removeBullet3(TempBullet3);
		}
		if(TempBullet3.getX() <= 0){

			TempBullet3.invertX();
		//	System.out.println("bullet3 deleted");
			//removeBullet3(TempBullet3);
		}
		if(TempBullet3.getY() >= (Game.HEIGHT * Game.SCALE)){

			TempBullet3.invertY();
		//	System.out.println("bullet3 deleted");
			//removeBullet3(TempBullet3);
		}
		if(TempBullet3.getX() >= (Game.WIDTH * Game.SCALE)){
			TempBullet3.invertX();
		//	System.out.println("bullet3 deleted");
		//	removeBullet3(TempBullet3);
		}
		
		TempBullet3.tick();
		for(int j = 0; j < e.size(); j ++)
		{
			if (TempBullet3.getY() < e.get(j).getY())
			{
				if(TempBullet3.getX() + 50 > (e.get(j).getX() - 16) && TempBullet3.getX() - 50 < (e.get(j).getX())+16)
				{		
					this.addExplosion(new Explosion(e.get(j).getX(),e.get(j).getY(),tex));
					removeEnnemy(e.get(j));
				if (ennemycount == 0)
				{
					for(int k = 0; k < Math.random() * (5-1); k++)
					{
					addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
					}
				}
				}
			}
			

			for(int l = 0; l < bos.size(); l ++)
			{
				if (TempBullet3.getY() < bos.get(l).getY() + 32 && TempBullet3.getY() > bos.get(l).getY() - 32)
				{
					if(TempBullet3.getX() > (bos.get(l).getX() - 32) && TempBullet3.getX() < (bos.get(l).getX())+32)
					{		
						this.addExplosion(new Explosion(bos.get(l).getX(),bos.get(l).getY(),tex));
						damagetaken(bos.get(l), 1);
					if (ennemycount == 0)
					{
						for(int k = 0; k < Math.random() * (5-1); k++)
						{
						//addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
						}
					}
					}
				}
			}
			
		}
	}
	
	for(int i = 0; i < ex.size(); i++)
	{
		TempExplosion = ex.get(i);
		if (TempExplosion.getFrame() <= 50)
		{
			TempExplosion.tick();
		}
		else
		{
			removeExplosion(TempExplosion);
		}
	}
	

	for(int i = 0; i < e.size(); i++){
		TempEnnemy = e.get(i);
		if(TempEnnemy.getY() > game.HEIGHT * game.SCALE) {
			TempEnnemy.setY(0);
			TempEnnemy.setX(Math.random() * (game.WIDTH * game.SCALE));
		}
		if(game.getP().getX() + 16 > TempEnnemy.getX() - 16 && game.getP().getX() - 16 < TempEnnemy.getX() - 16)
		{
			if(game.getP().getY() + 16 > TempEnnemy.getY() - 16 && game.getP().getY() - 16 < TempEnnemy.getY() - 16)
			{
				game.getP().setPv(game.getP().getPv() - 1);
			}
		}
		TempEnnemy.tick();
	}

	for(int i = 0; i < bos.size(); i++){
		TempBoss = bos.get(i);
		if(bos.get(i).phase2())
		{
			addBulletE(new BulletE(bos.get(i).getX(), bos.get(i).getY(), tex));
		}
		//if(TempBoss.getY() > game.HEIGHT * game.SCALE) {
		//	TempBoss.setY(0);
			//TempBoss.setX(Math.random() * (game.WIDTH * game.SCALE));
		//}
		if(game.getP().getX() + 16 > TempBoss.getX() - 16 && game.getP().getX() - 16 < TempBoss.getX() - 16)
		{
			if(game.getP().getY() + 16 > TempBoss.getY() - 16 && game.getP().getY() - 16 < TempBoss.getY() - 16)
			{
				game.getP().setPv(game.getP().getPv() - 1);
			}
		}
		TempBoss.tick();
	}
	
	

	for(int i = 0; i < bo.size(); i++){
		TempBonus = bo.get(i);
		if(TempBonus.getY() > game.HEIGHT * game.SCALE) {
			removeBonus(TempBonus);
		}
		if(game.getP().getX() + 16 > TempBonus.getX() - 16 && game.getP().getX() - 16 < TempBonus.getX() - 16)
		{
			if(game.getP().getY() + 16 > TempBonus.getY() - 16 && game.getP().getY() - 16 < TempBonus.getY() + 16)
			{
							/////////////////////////////////
			//addEnnemy(new Ennemy(Math.random() * (game.WIDTH * game.SCALE), 0, tex));
			this.addExplosion(new Explosion(TempBonus.getX() ,TempBonus.getY(),tex));
			removeBonus(bo.get(i));
			
			cptBullet2 += 10;
			}
		}
		TempBonus.tick();
	}
	
}

public int getEnemykilled() {
	return enemykilled;
}

public void render(Graphics g){
	for(int i = 0; i < b.size(); i++)
	{ 
		TempBullet = b.get(i);
		TempBullet.render(g);
	}
	for(int i = 0; i < b2.size(); i++)
	{ 
		TempBullet2 = b2.get(i);
		TempBullet2.render(g);
	}
	for(int i = 0; i < b3.size(); i++)
	{ 
		TempBullet3 = b3.get(i);
		TempBullet3.render(g);
	}
	for(int i = 0; i < be.size(); i++)
	{ 
		TempBulletE = be.get(i);
		TempBulletE.render(g);
	}
	for(int i = 0; i < ex.size(); i++)
	{ 
		TempExplosion = ex.get(i);
		TempExplosion.render(g);
	}
	for(int i = 0; i < e.size(); i++){
		TempEnnemy = e.get(i);
		TempEnnemy.render(g);
	}
	for(int i = 0; i < bo.size(); i++){
		TempBonus = bo.get(i);
		TempBonus.render(g);
	}
	for(int i = 0; i < bos.size(); i++){
		TempBoss = bos.get(i);
		TempBoss.render(g);
	}
}


public void damagetaken(Boss block, int j)
{
	if(block.isP1() == true)
	{
		if(block.getVie() > 0)
		{
			int k = block.getVie();
			k -= j;
			block.setVie(k);
			double h = block.getX();
			block.setX(h + 10);
			block.setX(Math.random() * (Game.WIDTH * Game.SCALE));
			block.setY(Math.random() * ((Game.HEIGHT * Game.SCALE) / 2));
		}
		else if (block.getVie() <= 0)
		{
			removeBoss(block);
		}
	}
}

public void addBullet(Bullet block){
	b.add(block);
}
public void removeBullet(Bullet block)
{
	b.remove(block);
}
public void addBoss(Boss block){
	bos.add(block);
}
public void removeBoss(Boss block)
{
	bos.remove(block);
}
public void addBullet2(Bullet2 block){
	if(cptBullet2 > 0)
	{
	b2.add(block);
	}
}
public void removeBullet2(Bullet2 block)
{
	b2.remove(block);
	cptBullet2--;
}
public void addBullet3(Bullet3 block){
	b3.add(block);
}
public void removeBullet3(Bullet3 block)
{
	b3.remove(block);
}
public void addBulletE(BulletE block){
	be.add(block);
}
public void removeBulletE(BulletE block)
{
	be.remove(block);
}
public void addEnnemy(Ennemy block){
	ennemycount++;
	e.add(block);
}
public void removeEnnemy(Ennemy block)
{
	ennemycount--;
	enemykilled++;
	e.remove(block);
}
public void addExplosion(Explosion block){
	ex.add(block);
}
public void removeExplosion(Explosion block)
{
	ex.remove(block);
}
public void addBonus(Bonus block){
	bo.add(block);
}
public void removeBonus(Bonus block)
{
	bo.remove(block);
}
}
