public class Gold extends MazeElement{
	private int points;
	private boolean visibility;

	public Gold(Location loc, int size, String imgString, int points){
		super(loc,size,imgString);
		this.points = points;
		visibility = true;
	}


	public int getPoints(){
		return points;
	}


	public void setPoints(int numOfPoints){
		points = numOfPoints;
	}


	public void setVisibility(boolean visibility){
		this.visibility = visibility;
	}


	public boolean isVisible(){
		return visibility;
	}
}