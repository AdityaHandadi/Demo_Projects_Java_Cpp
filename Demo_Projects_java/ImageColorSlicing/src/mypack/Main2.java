package mypack;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main2 {
	
	/* 
	 * Picking R=255, G=0, B=0 for red to be kept a1, a2, a3
	 * Light Yellow as b1, b2, b3
	 * w = 50
	 * 
	 * */
	
	public static void main(String[] args) {
		
		
		int a1=255,a2=0,a3=0;
		int b1=255,b2=255,b3=224;

		int w = 50;
		
		System.out.println("---------This program Color Slices Shades of Red for an Image---------------");
		
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Enter full file path");
    	String filepath = sc.nextLine();
    	
    	System.out.println("Enter file name with extension");
    	String filename = sc.nextLine();
    	
    	File originalImage =  new File(filepath+filename);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(originalImage);
			
			//Image for greyscaling result
			BufferedImage myBuffImage =  new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
			
			for(int i=0;i<img.getHeight();i++){
				for(int j=0;j<img.getWidth();j++){
					//Get RGB color object
					Color c = new Color(img.getRGB(j,i));
					
					int f1 = c.getRed();//f1
					int f2 = c.getGreen();//f2
					int f3 = c.getBlue();//f3
					int a = c.getAlpha();//a
					
					int g1 = b1,g2 = b2 ,g3 = b3;//if not red, set it to yellow
					
					if(Math.abs(f1-a1)<w && Math.abs(f2-a2)<w && Math.abs(f3-a3)<w){
						g1 = f1;g2 = f2 ;g3 = f3; //if red, keep same color
					}
					
					Color gColor=  new Color(g1,g2,g3,a);
					
					myBuffImage.setRGB(j, i, gColor.getRGB());
					
				}
			}	
			ImageIO.write(myBuffImage, "png", new File(filepath+"/image_.png"));
			
			System.out.println("File successfully sliced");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
