package com.game.src.main;

import java.awt.image.BufferedImage;

public class Texture {
	public BufferedImage[] player = new BufferedImage[5];
	public BufferedImage[] missile = new BufferedImage[4];
	public BufferedImage[] missile2 = new BufferedImage[3];
	public BufferedImage[] missile3 = new BufferedImage[3];
	public BufferedImage[] missileE = new BufferedImage[3];
	public BufferedImage[] ennemy = new BufferedImage[3];
	public BufferedImage[] boss = new BufferedImage[3];
	public BufferedImage[] ennemy2 = new BufferedImage[3];
	public BufferedImage[] ennemy3 = new BufferedImage[3];
	public BufferedImage[] explosion = new BufferedImage[10];
	public BufferedImage[] bonus = new BufferedImage[8];

	private SpriteSheet ss ;
	private SpriteSheet2 ss2 ;
	public Texture(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		ss2 = new SpriteSheet2(game.getSpriteSheet2());
		getTextures();
	}
	
	private void getTextures(){
		player[0] =ss.grabImage(1, 1, 32, 32);
		player[1] =ss.grabImage(1, 2, 32, 32);
		player[2] =ss.grabImage(1, 3, 32, 32);
		player[3] =ss.grabImage(1, 4, 32, 32);
		player[4] =ss.grabImage(1, 5, 32, 32);
		
		missile[0] = ss.grabImage(2, 1, 32, 32);
		missile[1] = ss.grabImage(2, 2, 32, 32);
		missile[2] = ss.grabImage(2, 3, 32, 32);
		missile[3] = ss.grabImage(2, 4, 32, 32);
		
		missile2[0] = ss.grabImage(7, 1, 32, 32);
		missile2[1] = ss.grabImage(7, 2, 32, 32);
		missile2[2] = ss.grabImage(7, 3, 32, 32);
		
		missile3[0] = ss.grabImage(9, 1, 32, 32);
		missile3[1] = ss.grabImage(9, 2, 32, 32);
		missile3[2] = ss.grabImage(9, 3, 32, 32);
		
		missileE[0] = ss.grabImage(10, 1, 32, 32);
		missileE[1] = ss.grabImage(10, 2, 32, 32);
		missileE[2] = ss.grabImage(10, 3, 32, 32);
		
		ennemy[0] = ss.grabImage(3, 1, 32, 32);
		ennemy[1] = ss.grabImage(3, 2, 32, 32);
		ennemy[2] = ss.grabImage(3, 3, 32, 32);
		
		ennemy2[0] = ss.grabImage(5, 1, 32, 32);
		ennemy2[1] = ss.grabImage(5, 2, 32, 32);
		ennemy2[2] = ss.grabImage(5, 3, 32, 32);
		
		ennemy3[0] = ss.grabImage(6, 1, 32, 32);
		ennemy3[1] = ss.grabImage(6, 2, 32, 32);
		ennemy3[2] = ss.grabImage(6, 3, 32, 32);
		
		boss[0] = ss2.grabImage(1, 1, 64, 64);
		boss[1] = ss2.grabImage(1, 2, 64, 64);
		boss[2] = ss2.grabImage(1, 3, 64, 64);
		
		explosion[0] = ss.grabImage(4, 1, 32, 32);
		explosion[1] = ss.grabImage(4, 2, 32, 32);
		explosion[2] = ss.grabImage(4, 3, 32, 32);
		explosion[3] = ss.grabImage(4, 4, 32, 32);
		explosion[4] = ss.grabImage(4, 5, 32, 32);
		explosion[5] = ss.grabImage(4, 6, 32, 32);
		explosion[6] = ss.grabImage(4, 7, 32, 32);
		explosion[7] = ss.grabImage(4, 8, 32, 32);
		explosion[8] = ss.grabImage(4, 9, 32, 32);
		explosion[9] = ss.grabImage(4, 10, 32, 32);
		
		bonus[0] = ss.grabImage(8, 1, 32, 32);
		bonus[1] = ss.grabImage(8, 2, 32, 32);
		bonus[2] = ss.grabImage(8, 3, 32, 32);
		bonus[3] = ss.grabImage(8, 4, 32, 32);
		bonus[4] = ss.grabImage(8, 5, 32, 32);
		bonus[5] = ss.grabImage(8, 6, 32, 32);
		bonus[6] = ss.grabImage(8, 7, 32, 32);
		bonus[7] = ss.grabImage(8, 8, 32, 32);
	}
}
