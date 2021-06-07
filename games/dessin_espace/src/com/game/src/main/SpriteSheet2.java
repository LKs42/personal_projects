package com.game.src.main;

import java.awt.image.BufferedImage;

public class SpriteSheet2 {
private BufferedImage image;
public SpriteSheet2(BufferedImage image){
	this.image = image;
}
public BufferedImage grabImage(int col, int row, int width, int height){
	BufferedImage img = image.getSubimage((col * 64)-64, (row * 64)-64 , width, height);
	return img;
}
}
