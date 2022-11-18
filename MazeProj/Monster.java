import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class Monster extends MazeElement{
    BufferedImage images;

	public Monster(Location loc, int size, String imgName){
		super(loc,size,imgName);
		try{
			images = ImageIO.read(new File("monster.png"));
        }catch(IOException e){
			System.out.println("Image not loaded");
	    }
	}


	//Returns the char representation of the collision object
	public void move(int key, char[][]maze){
		int r = getLoc().getR();
		int c = getLoc().getC();
		boolean moved = false;

		while(!moved){
			int dir = (int)(Math.random()*4);
			if(dir == 0){ //up
				if(r>0 && maze[r-1][c] == ' '){
					getLoc().incR(-1);
					moved = true;
			    }
		    }


		    if(dir == 1){ //right
		    	if(r<maze.length-1 && maze[r+1][c] ==' '){
					getLoc().incR(1);
					moved = true;
				}
		    }


		    if(dir == 3){ //left
		    	if(c>0 && maze[r][c-1] == ' '){
					getLoc().incC(-1);
					moved = true;
				}
		    }
		}
	}
}