package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "caca de les pace";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage spriteSheet2 = null;
	private BufferedImage background = null;
	
	private boolean is_shooting = false;
	
	private Player p;
	private Controller c;
	private Texture tex;
	private Menu menu;
	private OnScreen onscreen;
	
	
	public static enum STATE{
		MENU,
		GAME
	};
	
	public static STATE State = STATE.MENU;
	
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			
			spriteSheet = loader.loadImage("/sheet1.png");
			background = loader.loadImage("/bgstar1.png");
			spriteSheet2 = loader.loadImage("/sheet64.png");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
		addMouseMotionListener(new MouseInput(this));
		
		tex = new Texture(this);
		
		p = new Player (200, 200, tex);
		c = new Controller(this, tex);
		menu = new Menu();
		onscreen = new OnScreen();
	}
	
	private synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	private synchronized void stop(){
		if(!running) return;
		
		running = false;
		try{
		thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
		
	}
	
	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer > 1000)
			{
				timer += 1000;
				System.out.println(updates + "Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	private void tick(){
		if(State == STATE.GAME){
			p.tick();
			c.tick();
		}
		
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////
		
		g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
		
		g.drawImage(background,0,0,null);
		
		if(State == STATE.GAME){
		p.render(g);
		c.render(g);
		onscreen.render(g);
		}
		else if(State == STATE.MENU){
			menu.render(g);
		}
		////////////////////////////
		g.dispose();
		bs.show();
	}

	public void mouseClicked(MouseEvent e)
	{
	//q	if (State == STATE.GAME)
			//c.addBullet3(new Bullet3(e.getX() - 16 , e.getY() - 16, tex));
		System.out.println(e.getX()+ " " +e.getY());
		
		
	}
	public void mousePressed(MouseEvent e)
	{
		if (State == STATE.GAME){
			double x2 = e.getX();
			double y2 = e.getY();
			
			double x1 = p.getX();
			double y1 = p.getY();
			
			double Z = Math.sqrt( (x2-x1) * (x2-x1) + (y1-y2) * (y1-y2) );
			
			
			
			double cosalpha = 0;			
			double sinalpha = 0;

			cosalpha = (x2-x1)/Z ;
			sinalpha = (y1-y2)/Z ;
			
			//cosalpha = 2 ;
			//sinalpha = 2 ;
				
				c.addBullet3(new Bullet3(p.getX() - 16 , p.getY() - 16, tex, cosalpha, sinalpha));
		}
			
		System.out.println(e.getX()+ " " +e.getY());
	}

	public void mouseMoved(MouseEvent e)
	{
		//if (State == STATE.GAME)
			//c.addExplosion(new Explosion(e.getX(), e.getY(), tex));
		
		System.out.println(e.getX()+ " " +e.getY());
	}
	public void mouseDragged(MouseEvent e)
	{
		//if (State == STATE.GAME){
		//c.addExplosion(new Explosion(e.getX() - 16 , e.getY() - 16, tex));
	//	System.out.println(e.getX()+ " " +e.getY());
			
			
			
		
	}
	
public void mouseExited(MouseEvent e) {
	if (State == STATE.GAME){
		State = STATE.MENU;
		System.out.println(e.getX()+ " " +e.getY());
		}	
	}
	
	public void mouseEntered(MouseEvent e) {
		if (State == STATE.MENU){
			State = STATE.GAME;
			System.out.println(e.getX()+ " " +e.getY());
			}	
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(State == STATE.GAME){
			if (key == KeyEvent.VK_D)
			{
				p.setVelX(10);
			}
			else if (key == KeyEvent.VK_Q)
			{
				p.setVelX(-10);
			}
			else if (key == KeyEvent.VK_Z)
			{
				p.setVelY(-10);
			}
			else if (key == KeyEvent.VK_S)
			{
				p.setVelY(10);
			}
			else if (key == KeyEvent.VK_SPACE && !is_shooting)
			{
				is_shooting = true;
				c.addBullet(new Bullet(p.getX(), p.getY(), tex));
			}
			else if (key == KeyEvent.VK_SHIFT && !is_shooting)
			{
				is_shooting = true;
				c.addBullet2(new Bullet2(p.getX(), p.getY(), tex));
			}
			else if (key == KeyEvent.VK_ESCAPE)
			{
				State = STATE.MENU;
			}
		}
	}
	public Player getP() {
		return p;
	}

	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_D)
		{
			p.setVelX(0);
		}
		else if (key == KeyEvent.VK_Q)
		{
			p.setVelX(0);
		}
		else if (key == KeyEvent.VK_Z)
		{
			p.setVelY(0);
		}
		else if (key == KeyEvent.VK_S)
		{
			p.setVelY(0);
		}
		else if (key == KeyEvent.VK_SPACE )
		{
			is_shooting = false;
		}
		else if (key == KeyEvent.VK_SHIFT )
		{
			is_shooting = false;
		}
		
	}
	public void keyTyped(KeyEvent e){
		
	}
	
	public static void main (String args[]){
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		game.start();
	}

	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	public BufferedImage getSpriteSheet2() {
		return spriteSheet2;
	}

	public void setSpriteSheet2(BufferedImage spriteSheet) {
		this.spriteSheet2 = spriteSheet;
	}

}
