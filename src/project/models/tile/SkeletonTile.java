package project.models.tile;

/**
 * This is a subclass of the class FindingTiles that calculates all the
 * parts of the skeleton body (upper, under).
 */
public class SkeletonTile extends FindingTile {
    private String color;
	private int pieces_pl;
    
    public SkeletonTile(int id) {
        super(id);
    }
    
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Gets from his subclasses all the parts
	 * of the skeleton body and calculated the points
	 * @return The points
	 */
	public int Skeleton_body_points() {
		setPieces_pl(0);
		return 0;
	}
    public String getColor() {
    	this.getPieces_pl();
        return color;
    }
    
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Materializes the skeleton
	 */
	public void skeleton_materialize() {
		int tmp = getPieces_pl();
	}
	
    public void setColor(String color) {
    	this.getPieces_pl();
        this.color = color;
    }

	public int getPieces_pl() {
		return pieces_pl;
	}

	public void setPieces_pl(int pieces_pl) {
		this.pieces_pl = pieces_pl;
	}
}