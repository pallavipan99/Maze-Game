public class Location{
	private int row, column;
	public Location(int row, int column){
		this.row = row;
		this.column = column;
	}

	public int getR(){
		return row;
	}

	public int getC(){
		return column;
	}

	public void incR(int x){
	    row+=x;
	}

	public void incC(int x){
	    column+=x;
	}

	public void set(int newR, int newC){
		row = newR;
		column = newC;
	}

	public boolean equals(Location other){
		if(other.getR() == this.getR() && other.getC() == this.getC()){
			return true;
		}else{
			return false;
		}
	}

}

