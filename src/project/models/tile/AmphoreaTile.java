 package project.models.tile;
 /**
  * This is a subclass of the class FindingTile that finds the amphoras tiles. Basicly it calculates 
  * the poitns of amphora.
  */
public class AmphoreaTile  extends FindingTile{
	private boolean mat = false;
    private String color; 
	
	public AmphoreaTile(int id) {
    	super(id);
    	this.mat = false;
    }
      
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Calculating the points of Amphora and returns them 
	 * @return The points
	 */
	public int amphora_points() {
		int score1 = 0;
		return score1;
	}

    public String getColor() {
        return color;
    }
    
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Materializes the amphora
	 */
	public void amphora_materialize() {
		this.mat = true;
	}
	
    public void setColor(String color) {
        this.color = color;
    }
}