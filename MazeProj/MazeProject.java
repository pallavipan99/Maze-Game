import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class MazeProject extends JPanel implements KeyListener, ActionListener
{
	private JFrame frame;
	private int size = 30, width = 1500, height = 1000;
	private char[][] maze;
	private Timer t;
	private MazeElement finish;
	private Explorer explorer;
	private Monster monster;
	private int steps;
	private boolean loadNext;
	private int level = 0;
	private String message="";
	private Gold gold;
	private int numOfPoints;
	private boolean ending;
	private String result;
	private BufferedImage image;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;



	public MazeProject(){
		//Maze variables
		setBoard("maze0.txt");
		frame=new JFrame("A-Mazing Program");
		frame.setSize(width,height);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		t = new Timer(500, this);  // will trigger actionPerformed every 500 ms
		t.start();

		try{ // Loads images
		image = ImageIO.read(new File("celeb.png"));
		image2 = ImageIO.read(new File("fireworks.png"));
	    image3 = ImageIO.read(new File("confetti.png"));
	    image4 = ImageIO.read(new File("giftbox.png"));
	    }catch(IOException e){
			System.out.println("Image not loaded");
		}

    }


	// All Graphics handled in this method.
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,frame.getWidth(),frame.getHeight());

		for(int r=0;r<maze.length;r++){
			for(int c=0;c<maze[0].length;c++){
				g2.setColor(Color.GRAY);
				if (maze[r][c]=='#')
					g2.fillRect(c*size+size,r*size+size,size,size); //Wall
				else
					g2.drawRect(c*size+size,r*size+size,size,size);  //Open

					// Paint MazeElements
					Location here = new Location(r,c);
					if (here.equals(finish.getLoc())){
						g2.drawImage(finish.getImg(), c*size+size,r*size+size,size,size,null, this);
				    }

				    if(here.equals(explorer.getLoc())){
					   g2.drawImage(explorer.getImg(), c*size+size,r*size+size,size,size,null, this);
					}

					if(here.equals(monster.getLoc())){
					   g2.drawImage(monster.getImg(), c*size+size,r*size+size,size,size,null, this);
					}

					if(here.equals(gold.getLoc())){
					 	g2.drawImage(gold.getImg(), c*size+size,r*size+size,size,size,null, this);
					}
				}
	     	}


		// Display at bottom of page
		int hor = size;
		int vert = maze.length*size+ 2*size;
		g2.setFont(new Font("Arial",Font.BOLD,20));
		g2.setColor(Color.PINK);
		g2.drawString("Step Count =>  "+steps,hor,vert);
		g2.setColor(Color.BLUE);

		if(loadNext==true){
			g2.drawString("MAZE COMPLETED! Press the space key to continue",size-4, vert+70);
	    }

	    if(message.equals("You had collided with the monster! You loose a point!")){
			g2.drawString(message,size-4, vert+50 );
		}

		g2.setColor(Color.GREEN);
		g2.drawString("Number of points you have so far: "+numOfPoints,size-5, vert+25 );

		// shows the congratulations graphics
		if(ending == true){
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,1000,1000);
			g2.setColor(Color.PINK);
			g2.drawString(result,size+30, vert+40);
			g2.drawImage(image,0,0,100,100,null, this);
			g2.drawImage(image2,800,0,100,100,null, this);
			g2.drawImage(image3,800,50,100,100,null, this);
			g2.drawImage(image4,500,400,300,300,null, this);
		}

	}


	public void keyPressed(KeyEvent e)
	{
		if(explorer.intersects(gold) &&e.getKeyCode() == 10){
			numOfPoints++;
		}

		if(explorer.intersects(monster) && e.getKeyCode()==38){
			message = "You had collided with the monster! You loose a point!";
			numOfPoints--;
		}

		if(e.getKeyCode()==10){
		   message = " ";
		}

		if(numOfPoints>3){
			numOfPoints = 3;
		}

		if(e.getKeyCode() == 38){
			steps++;
		}

		System.out.println(e.getKeyCode());
		explorer.move(e.getKeyCode(),maze);
		if(explorer.intersects(finish))
		{
			loadNext = true;
			level +=1;
			if(e.getKeyCode() == 32 && level==2)
			{
				setBoard("maze1.txt");
				steps = 0;
				loadNext = false;
			}

			if(e.getKeyCode() == 32 & level == 4){
				setBoard("maze2.txt");
					steps = 0;
					loadNext = false;
				}

				if(e.getKeyCode() == 32 & level == 6){
					setBoard("maze0.txt");
					ending = true;
					result = explorer.getResults(numOfPoints);
					System.out.print(result);
					steps = 0;
					loadNext = false;
				}
	       }
		repaint();
	  }


	/*** empty methods needed for interfaces **/
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	public void actionPerformed(ActionEvent e) {
		  //  monster.move(0,maze);
		    repaint();
		}


	public void setBoard(String fileName){
		ArrayList<String>list = new ArrayList<String>();

		File name = new File(fileName);  // File name must match that on computer
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text,output="";
			while((text=input.readLine())!= null){
			list.add(text);
			}

			for(int i = 0; i<list.size();i++){
				if(list.get(0).length()!=list.get(i).length()){
					throw new IOException("oops, something went wrong");
			    }
			}

	    } catch (IOException io){
			System.err.println("Error reading file => "+io);
		}

		char[][] temp = new char [list.size()][list.get(0).length()];

		for(int x = 0; x<temp.length; x++){
			for(int y = 0; y<temp[0].length; y++){
				temp[x][y] = list.get(x).charAt(y);
				char symbol = temp[x][y];
				if(symbol =='F'){
					finish =  new MazeElement(new Location(x,y),size,"finish.png");
					temp[x][y] = symbol;
				}

				if(symbol == 'E'){
					explorer = new Explorer(new Location(x,y),size);
				}

				if(symbol == ' '){
				   monster = new Monster(new Location(x,y),size,"monster.png");
				}

				if(symbol == 'G'){
				   gold = new Gold(new Location(x,y),size,"Gold.png",1);
				}

			}
	    }
		maze = temp;
	}

	public static void main(String[] args){
		MazeProject app=new MazeProject();
	}
}