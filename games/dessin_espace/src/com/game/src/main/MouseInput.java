package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
	
	Game game;
	private int mx;
	private int my;
	
	
	
	public MouseInput(Game game){
		this.game = game;
	}
	
	public void mouseMoved(MouseEvent e){

		game.mouseMoved(e);
	}
	
	public void mouseClicked(MouseEvent e) {

		game.mouseClicked(e);
		
		mx = e.getX();
		my = e.getY();
		
		if( mx >= Game.WIDTH /2 + 120 && mx <= Game.WIDTH / 2 + 220)
		{
			if (my >= 150 && my <= 200)
			{
				Game.State = Game.STATE.GAME;
			}
		}
		
		if( mx >= Game.WIDTH /2 + 120 && mx <= Game.WIDTH / 2 + 220)
		{
			if (my >= 150 && my <= 200)
			{
			
			}
		}
		
		if( mx >= Game.WIDTH /2 + 120 && mx <= Game.WIDTH / 2 + 220)
		{
			if (my >= 350 && my <= 400)
			{
				System.exit(1);
			}
		}
		
	}


	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}

	public void mouseEntered(MouseEvent e) {
		game.mouseEntered(e);
	}

	public void mouseExited(MouseEvent e) {
		game.mouseExited(e);
	}

	public void mousePressed(MouseEvent e) {
		game.mousePressed(e);
		//mx = e.getX();
		//my = e.getY();
		
		/*
		public Rectangle playButton = new Rectangle(Game.WIDTH /2+120,150,100,50);
		public Rectangle helpButton = new Rectangle(Game.WIDTH /2+120,250,100,50);
		public Rectangle quitButton = new Rectangle(Game.WIDTH /2+120,350,100,50);
		*/	
		
		
		
	}


	public void mouseReleased(MouseEvent e) {

		
	}

	public void mouseDragged(MouseEvent e) {
		game.mouseDragged(e);
		
	}

	

}
