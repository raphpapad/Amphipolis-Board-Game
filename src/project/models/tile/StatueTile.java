package project.models.tile;

/**
 *  This is a subclass of the class FindingTiles that finds
 * the what piece is the stauted (they are to kinds of statued
 * caryatid and sphinx) 
 */
public  abstract class StatueTile extends FindingTile  {
    
    private int pl;

	public StatueTile(int id) {
        super(id);
    }
    
	/**
	 * <br>precondition: Valid statue pieces
	 * <br>postcondition: Gets from his subclasses all 
	 * the pieces of statues and calculates the points
	 * @return The points
	 */
	public int Statue_pieces() {
		setPl(0);
		return 0;
	}

	public int getPl() {
		return pl;
	}

	public void setPl(int pl) {
		this.pl = pl;
	}
}