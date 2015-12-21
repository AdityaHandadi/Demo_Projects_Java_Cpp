package com.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	/* 
	 * Picking R=255, G=0, B=0 for red as b1, b2, b3
	 * w = 50
	 * a1 = 10, a2 = 20, a3 = 30
	 * */
	
	public static void main(String[] args) {
		
		File originalImage =  new File("/Users/adityahandadi/Documents/image.png");
		
		int a1=255,a2=0,a3=0;
		int b1=255,b2=255,b3=224;
		
		/*int a1=255, a2=0, a3=0;
		int b1=0, b2=255, b3=0;*/
		
		int w = 50;
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(originalImage);
			
			//Image for greyscaling result
			BufferedImage greyscaleImage =  new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
			
			for(int i=0;i<img.getHeight();i++){
				for(int j=0;j<img.getWidth();j++){
					//Get RGB color object
					Color c = new Color(img.getRGB(j,i));
					
					int f1 = c.getRed();//f1
					int f2 = c.getGreen();//f2
					int f3 = c.getBlue();//f3
					int a = c.getAlpha();//a
					
					int g1 = f1,g2 = f2 ,g3 = f3;
					
					if(Math.abs(f1-a1)>w){
						g1 = b1;
					}
					if(Math.abs(f2-a2)>w){
						g2 = b2;
					}
					if(Math.abs(f3-a3)>w){
						g3 = b3;
					}
					
					Color gColor=  new Color(g1,g2,g3,a);
					
					greyscaleImage.setRGB(j, i, gColor.getRGB());
					
				}
			}	
			ImageIO.write(greyscaleImage, "png", new File("/Users/adityahandadi/Documents/image_.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
