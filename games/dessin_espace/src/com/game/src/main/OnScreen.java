package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class OnScreen {
	
	public Rectangle Bullet2 = new Rectangle(10,Game.HEIGHT * Game.SCALE - 50,100,50);
	
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);

		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString((String.valueOf(Controller.cptBullet2)) , Bullet2.x + 40, Bullet2.y + 30);
		g2d.draw(Bullet2);
		}

}
