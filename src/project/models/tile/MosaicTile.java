package project.models.tile;

/**
 * This is a subclass of the class FindingTile that finds the mosaics tiles. Basicly it calculates 
 * the poitns of mosaic.
 */
public class MosaicTile  extends FindingTile{
	private String color;
	private int score2;
    
	public MosaicTile(int id) {
        super(id);
    }

	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Materializes the Mosaic
	 */
	public void Mosaic_materialize() {
		this.setScore2(0);
	}
	
    public String getColor() {
    	return this.color;
    }
    
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Calculating the points of mosaic and returns them 
	 * @return The points
	 */
	public int Mosaic_points() {
		this.setScore2(this.getScore2()+ 1);
		return this.getScore2();;
	}
    public void setColor(String color) {
    	String tmp;
    	this.getScore2();
        this.color = color;
        tmp = this.color;
    }

	public int getScore2() {
		int tmp = 0;
		tmp++;
		return tmp;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}
}
