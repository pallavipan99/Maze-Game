import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class Explorer extends MazeElement{
	private int dir;
	private int steps;
	public static final String[] IMG_NAMES = {"expNorth.png","expEast.png","expSouth.png","expWest.png"}; /// fill with all 4 versions
    private BufferedImage[] images;

	public Explorer(Location loc, int size){
		super(loc,size);
		dir = 1; // facing East default
		steps = 0; //no steps taken
		images = new BufferedImage[IMG_NAMES.length];
		for(int i = 0; i< IMG_NAMES.length; i++){
			try{
			   images[i] = ImageIO.read(new File(IMG_NAMES[i]));
			} catch(IOException e){
				System.out.println("Image "+ IMG_NAMES[i]+" not loaded");
			}
		}
	}


	// returns image based on direction
			@Override
		public BufferedImage getImg()
			{
				return images[dir];
	        }


	@Override
	public void move(int key, char[][] maze) {
		if(key == 39){ // right arrow
			if(dir == 3)
				dir = 0;
			else
				dir++;
		}


		if(key == 37){ // left arrow
			if(dir == 0)
				dir = 3;
			else
				dir--;
		}


		if(key == 38){ //up arrow
		    steps++;
			int r = getLoc().getR();
			int c = getLoc().getC();
			if(dir ==0){ // Facing North
				if(r>0 && (maze[r-1][c] == ' ' || maze[r-1][c] == 'F'||maze[r-1][c] == 'G'))
					getLoc().incR(-1);
			}

			if(dir ==1){ // Facing East
				if(c+1<maze[r].length && (maze[r][c+1] == ' ' || maze[r][c+1] == 'F'||maze[r][c+1] == 'G'))
					getLoc().incC(1);
			}

			if(dir ==2){ // Facing South
				if(r+1<maze[r].length && (maze[r+1][c] == ' ' || maze[r+1][c] == 'F'|| maze[r+1][c] == 'G'))
					getLoc().incR(1);
			}

			if(dir ==3){ // Facing  West
				if(c>0 && (maze[r][c-1] == ' ' || maze[r][c-1] == 'F'||maze[r][c-1] == 'G'))
					getLoc().incC(-1);
			}

		}
   }



   //returns the result given the number of points
   public String getResults(int num){
   			String result = " ";
   			if(num>=0){
   				result = "Congratulations! You won the game!";
   			}
   			if(num<0){
   				result = "Sorry! You lost the game, but congratulations on getting through all the mazes!";
   			}
   			return result;
		}

}
